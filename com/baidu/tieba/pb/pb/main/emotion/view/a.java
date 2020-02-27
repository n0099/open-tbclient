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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> gaD;
    private EmotionView.a iRp;
    private int iSu;
    private PbEmotionBar.a iSv;
    private Set<String> ivW = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gaD)) {
            return 0;
        }
        return this.gaD.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gaD = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0580a c0580a;
        if (view == null) {
            c0580a = new C0580a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0580a.iwe = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0580a.iwe.bzP();
            c0580a.iwe.setController(this.iRp);
            c0580a.iwe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iSv != null && (view2 instanceof EmotionView)) {
                        a.this.iSv.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0580a.gzn = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0580a.gzn, (int) R.color.cp_cont_d);
            c0580a.gzn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iSv != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gaD)) {
                            for (EmotionImageData emotionImageData : a.this.gaD) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iSv.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0580a);
        } else {
            c0580a = (C0580a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gaD.size()) {
                c0580a.iwe.getLayoutParams().width = this.iSu;
                c0580a.iwe.getLayoutParams().height = this.iSu;
                c0580a.iwe.reset();
                c0580a.iwe.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gaD.get(i);
                if (emotionImageData != null) {
                    c0580a.iwe.a(emotionImageData);
                    if (this.ivW != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.ivW.add(emotionImageData.getThumbUrl() + c0580a.iwe.getLoadProcType());
                    }
                }
                c0580a.iwe.setVisibility(0);
                c0580a.gzn.setVisibility(8);
            } else if (i == this.gaD.size()) {
                c0580a.gzn.getLayoutParams().width = this.iSu;
                c0580a.gzn.getLayoutParams().height = this.iSu;
                c0580a.iwe.setVisibility(8);
                c0580a.gzn.setVisibility(0);
            }
        }
        return view;
    }

    public void zj(int i) {
        if (this.iSu != i) {
            this.iSu = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.iRp = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iSv = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0580a {
        TextView gzn;
        EmotionView iwe;

        C0580a() {
        }
    }

    public void ciA() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.ivW != null) {
                    for (String str : a.this.ivW) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aPO().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
