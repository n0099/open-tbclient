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
    private List<EmotionImageData> cLz;
    private Set<String> eXM = new HashSet();
    private EmotionView.a fsd;
    private int ftg;
    private PbEmotionBar.a fth;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cLz)) {
            return 0;
        }
        return this.cLz.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cLz = list;
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
            c0195a.eXU = (EmotionView) view2.findViewById(d.g.iv_emotion);
            c0195a.eXU.alB();
            c0195a.eXU.setController(this.fsd);
            c0195a.eXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (a.this.fth != null && (view3 instanceof EmotionView)) {
                        a.this.fth.b(((EmotionView) view3).getData(), ((EmotionView) view3).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0195a.dhd = (TextView) view2.findViewById(d.g.tv_more);
            ak.h(c0195a.dhd, d.C0126d.cp_cont_d);
            c0195a.dhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (a.this.fth != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.w(a.this.cLz)) {
                            for (EmotionImageData emotionImageData : a.this.cLz) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fth.a(null, null, arrayList);
                    }
                }
            });
            view2.setTag(c0195a);
        } else {
            c0195a = (C0195a) view2.getTag();
        }
        if (i >= 0) {
            if (i < this.cLz.size()) {
                c0195a.eXU.getLayoutParams().width = this.ftg;
                c0195a.eXU.getLayoutParams().height = this.ftg;
                c0195a.eXU.reset();
                c0195a.eXU.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cLz.get(i);
                if (emotionImageData != null) {
                    c0195a.eXU.a(emotionImageData);
                    if (this.eXM != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eXM.add(emotionImageData.getThumbUrl() + c0195a.eXU.getLoadProcType());
                    }
                }
                c0195a.eXU.setVisibility(0);
                c0195a.dhd.setVisibility(8);
            } else if (i == this.cLz.size()) {
                c0195a.dhd.getLayoutParams().width = this.ftg;
                c0195a.dhd.getLayoutParams().height = this.ftg;
                c0195a.eXU.setVisibility(8);
                c0195a.dhd.setVisibility(0);
            }
        }
        return view2;
    }

    public void qA(int i) {
        if (this.ftg != i) {
            this.ftg = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fsd = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fth = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0195a {
        TextView dhd;
        EmotionView eXU;

        C0195a() {
        }
    }

    public void aTN() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.eXM != null) {
                    for (String str : a.this.eXM) {
                        if (!TextUtils.isEmpty(str)) {
                            c.EY().gE(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
