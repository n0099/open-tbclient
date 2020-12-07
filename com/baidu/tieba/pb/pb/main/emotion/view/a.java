package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> iFh;
    private EmotionView.a lSX;
    private int lUc;
    private PbEmotionBar.a lUd;
    private Set<String> ltw = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iFh)) {
            return 0;
        }
        return this.iFh.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iFh = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0836a c0836a;
        if (view == null) {
            c0836a = new C0836a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0836a.ltE = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0836a.ltE.cxT();
            c0836a.ltE.setController(this.lSX);
            c0836a.ltE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lUd != null && (view2 instanceof EmotionView)) {
                        a.this.lUd.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0836a.jjy = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0836a.jjy, R.color.CAM_X0109);
            c0836a.jjy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lUd != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.iFh)) {
                            for (EmotionImageData emotionImageData : a.this.iFh) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lUd.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0836a);
        } else {
            c0836a = (C0836a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iFh.size()) {
                c0836a.ltE.getLayoutParams().width = this.lUc;
                c0836a.ltE.getLayoutParams().height = this.lUc;
                c0836a.ltE.reset();
                c0836a.ltE.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iFh.get(i);
                if (emotionImageData != null) {
                    c0836a.ltE.a(emotionImageData);
                    if (this.ltw != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.ltw.add(emotionImageData.getThumbUrl() + c0836a.ltE.getLoadProcType());
                    }
                }
                c0836a.ltE.setVisibility(0);
                c0836a.jjy.setVisibility(8);
            } else if (i == this.iFh.size()) {
                c0836a.jjy.getLayoutParams().width = this.lUc;
                c0836a.jjy.getLayoutParams().height = this.lUc;
                c0836a.ltE.setVisibility(8);
                c0836a.jjy.setVisibility(0);
            }
        }
        return view;
    }

    public void HB(int i) {
        if (this.lUc != i) {
            this.lUc = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lSX = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lUd = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0836a {
        TextView jjy;
        EmotionView ltE;

        C0836a() {
        }
    }

    public void dkS() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.ltw != null) {
                    for (String str : a.this.ltw) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bDV().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
