package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> fYD;
    private EmotionView.a iPU;
    private int iQZ;
    private PbEmotionBar.a iRa;
    private Set<String> iub = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fYD)) {
            return 0;
        }
        return this.fYD.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fYD = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0573a c0573a;
        if (view == null) {
            c0573a = new C0573a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0573a.iuj = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0573a.iuj.byn();
            c0573a.iuj.setController(this.iPU);
            c0573a.iuj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iRa != null && (view2 instanceof EmotionView)) {
                        a.this.iRa.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0573a.gxm = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0573a.gxm, (int) R.color.cp_cont_d);
            c0573a.gxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iRa != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.fYD)) {
                            for (EmotionImageData emotionImageData : a.this.fYD) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iRa.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0573a);
        } else {
            c0573a = (C0573a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.fYD.size()) {
                c0573a.iuj.getLayoutParams().width = this.iQZ;
                c0573a.iuj.getLayoutParams().height = this.iQZ;
                c0573a.iuj.reset();
                c0573a.iuj.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.fYD.get(i);
                if (emotionImageData != null) {
                    c0573a.iuj.a(emotionImageData);
                    if (this.iub != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.iub.add(emotionImageData.getThumbUrl() + c0573a.iuj.getLoadProcType());
                    }
                }
                c0573a.iuj.setVisibility(0);
                c0573a.gxm.setVisibility(8);
            } else if (i == this.fYD.size()) {
                c0573a.gxm.getLayoutParams().width = this.iQZ;
                c0573a.gxm.getLayoutParams().height = this.iQZ;
                c0573a.iuj.setVisibility(8);
                c0573a.gxm.setVisibility(0);
            }
        }
        return view;
    }

    public void zd(int i) {
        if (this.iQZ != i) {
            this.iQZ = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.iPU = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iRa = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0573a {
        TextView gxm;
        EmotionView iuj;

        C0573a() {
        }
    }

    public void cgV() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.iub != null) {
                    for (String str : a.this.iub) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aNs().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
