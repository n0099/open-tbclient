package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> cKv;
    private Set<String> eWI = new HashSet();
    private EmotionView.a fqY;
    private int fsc;
    private PbEmotionBar.a fsd;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cKv)) {
            return 0;
        }
        return this.cKv.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cKv = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0195a c0195a;
        if (view2 == null) {
            c0195a = new C0195a();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_pb_emotion_bar, (ViewGroup) null);
            c0195a.eWQ = (EmotionView) view2.findViewById(d.g.iv_emotion);
            c0195a.eWQ.alB();
            c0195a.eWQ.setController(this.fqY);
            c0195a.eWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (a.this.fsd != null && (view3 instanceof EmotionView)) {
                        a.this.fsd.b(((EmotionView) view3).getData(), ((EmotionView) view3).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0195a.dfZ = (TextView) view2.findViewById(d.g.tv_more);
            ak.h(c0195a.dfZ, d.C0126d.cp_cont_d);
            c0195a.dfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (a.this.fsd != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.w(a.this.cKv)) {
                            for (EmotionImageData emotionImageData : a.this.cKv) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fsd.a(null, null, arrayList);
                    }
                }
            });
            view2.setTag(c0195a);
        } else {
            c0195a = (C0195a) view2.getTag();
        }
        if (i >= 0) {
            if (i < this.cKv.size()) {
                c0195a.eWQ.getLayoutParams().width = this.fsc;
                c0195a.eWQ.getLayoutParams().height = this.fsc;
                c0195a.eWQ.reset();
                c0195a.eWQ.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cKv.get(i);
                if (emotionImageData != null) {
                    c0195a.eWQ.a(emotionImageData);
                    if (this.eWI != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eWI.add(emotionImageData.getThumbUrl() + c0195a.eWQ.getLoadProcType());
                    }
                }
                c0195a.eWQ.setVisibility(0);
                c0195a.dfZ.setVisibility(8);
            } else if (i == this.cKv.size()) {
                c0195a.dfZ.getLayoutParams().width = this.fsc;
                c0195a.dfZ.getLayoutParams().height = this.fsc;
                c0195a.eWQ.setVisibility(8);
                c0195a.dfZ.setVisibility(0);
            }
        }
        return view2;
    }

    public void qC(int i) {
        if (this.fsc != i) {
            this.fsc = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fqY = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fsd = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0195a {
        TextView dfZ;
        EmotionView eWQ;

        C0195a() {
        }
    }

    public void aTN() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.eWI != null) {
                    for (String str : a.this.eWI) {
                        if (!TextUtils.isEmpty(str)) {
                            c.Fa().gE(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
