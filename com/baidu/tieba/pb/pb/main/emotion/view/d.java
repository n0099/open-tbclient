package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private List<EmotionImageData> cmi;
    private Set<String> eCn = new HashSet();
    private EmotionView.a eUT;
    private c.a eXA;
    private int eXz;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.cmi)) {
            return 0;
        }
        return this.cmi.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cmi = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_pb_emotion_bar, (ViewGroup) null);
            aVar.eCv = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.eCv.afH();
            aVar.eCv.setController(this.eUT);
            aVar.eCv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eXA != null && (view2 instanceof EmotionView)) {
                        d.this.eXA.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.cGV = (TextView) view.findViewById(d.g.tv_more);
            aj.i(aVar.cGV, d.C0080d.cp_cont_d);
            aVar.cGV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eXA != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.v(d.this.cmi)) {
                            for (EmotionImageData emotionImageData : d.this.cmi) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        d.this.eXA.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cmi.size()) {
                aVar.eCv.getLayoutParams().width = this.eXz;
                aVar.eCv.getLayoutParams().height = this.eXz;
                aVar.eCv.reset();
                aVar.eCv.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cmi.get(i);
                if (emotionImageData != null) {
                    aVar.eCv.a(emotionImageData);
                    if (this.eCn != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eCn.add(emotionImageData.getThumbUrl() + aVar.eCv.getLoadProcType());
                    }
                }
                aVar.eCv.setVisibility(0);
                aVar.cGV.setVisibility(8);
            } else if (i == this.cmi.size()) {
                aVar.cGV.getLayoutParams().width = this.eXz;
                aVar.cGV.getLayoutParams().height = this.eXz;
                aVar.eCv.setVisibility(8);
                aVar.cGV.setVisibility(0);
            }
        }
        return view;
    }

    public void pW(int i) {
        if (this.eXz != i) {
            this.eXz = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.eUT = aVar;
    }

    public void a(c.a aVar) {
        this.eXA = aVar;
    }

    /* loaded from: classes.dex */
    class a {
        TextView cGV;
        EmotionView eCv;

        a() {
        }
    }

    public void aOI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eCn != null) {
                    for (String str : d.this.eCn) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Eg().gm(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
