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
    private List<EmotionImageData> cmB;
    private Set<String> eCH = new HashSet();
    private EmotionView.a eVo;
    private int eXU;
    private c.a eXV;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.cmB)) {
            return 0;
        }
        return this.cmB.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cmB = list;
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
            aVar.eCP = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.eCP.afV();
            aVar.eCP.setController(this.eVo);
            aVar.eCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eXV != null && (view2 instanceof EmotionView)) {
                        d.this.eXV.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.cHo = (TextView) view.findViewById(d.g.tv_more);
            aj.i(aVar.cHo, d.C0080d.cp_cont_d);
            aVar.cHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eXV != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.v(d.this.cmB)) {
                            for (EmotionImageData emotionImageData : d.this.cmB) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        d.this.eXV.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cmB.size()) {
                aVar.eCP.getLayoutParams().width = this.eXU;
                aVar.eCP.getLayoutParams().height = this.eXU;
                aVar.eCP.reset();
                aVar.eCP.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cmB.get(i);
                if (emotionImageData != null) {
                    aVar.eCP.a(emotionImageData);
                    if (this.eCH != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eCH.add(emotionImageData.getThumbUrl() + aVar.eCP.getLoadProcType());
                    }
                }
                aVar.eCP.setVisibility(0);
                aVar.cHo.setVisibility(8);
            } else if (i == this.cmB.size()) {
                aVar.cHo.getLayoutParams().width = this.eXU;
                aVar.cHo.getLayoutParams().height = this.eXU;
                aVar.eCP.setVisibility(8);
                aVar.cHo.setVisibility(0);
            }
        }
        return view;
    }

    public void pX(int i) {
        if (this.eXU != i) {
            this.eXU = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.eVo = aVar;
    }

    public void a(c.a aVar) {
        this.eXV = aVar;
    }

    /* loaded from: classes.dex */
    class a {
        TextView cHo;
        EmotionView eCP;

        a() {
        }
    }

    public void aOQ() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eCH != null) {
                    for (String str : d.this.eCH) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Es().gn(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
