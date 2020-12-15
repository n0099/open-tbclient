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
    private List<EmotionImageData> iFj;
    private EmotionView.a lSZ;
    private int lUe;
    private PbEmotionBar.a lUf;
    private Set<String> lty = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iFj)) {
            return 0;
        }
        return this.iFj.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iFj = list;
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
            c0836a.ltG = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0836a.ltG.cxU();
            c0836a.ltG.setController(this.lSZ);
            c0836a.ltG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lUf != null && (view2 instanceof EmotionView)) {
                        a.this.lUf.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0836a.jjA = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0836a.jjA, R.color.CAM_X0109);
            c0836a.jjA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lUf != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.iFj)) {
                            for (EmotionImageData emotionImageData : a.this.iFj) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lUf.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0836a);
        } else {
            c0836a = (C0836a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iFj.size()) {
                c0836a.ltG.getLayoutParams().width = this.lUe;
                c0836a.ltG.getLayoutParams().height = this.lUe;
                c0836a.ltG.reset();
                c0836a.ltG.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iFj.get(i);
                if (emotionImageData != null) {
                    c0836a.ltG.a(emotionImageData);
                    if (this.lty != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lty.add(emotionImageData.getThumbUrl() + c0836a.ltG.getLoadProcType());
                    }
                }
                c0836a.ltG.setVisibility(0);
                c0836a.jjA.setVisibility(8);
            } else if (i == this.iFj.size()) {
                c0836a.jjA.getLayoutParams().width = this.lUe;
                c0836a.jjA.getLayoutParams().height = this.lUe;
                c0836a.ltG.setVisibility(8);
                c0836a.jjA.setVisibility(0);
            }
        }
        return view;
    }

    public void HB(int i) {
        if (this.lUe != i) {
            this.lUe = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lSZ = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lUf = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0836a {
        TextView jjA;
        EmotionView ltG;

        C0836a() {
        }
    }

    public void dkT() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lty != null) {
                    for (String str : a.this.lty) {
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
