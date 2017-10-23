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
    private List<EmotionImageData> ceO;
    private EmotionView.a eLZ;
    private int eOH;
    private c.a eOI;
    private Set<String> eue = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.u(this.ceO)) {
            return 0;
        }
        return this.ceO.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.ceO = list;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_item_pb_emotion_bar, (ViewGroup) null);
            aVar.eum = (EmotionView) view.findViewById(d.h.iv_emotion);
            aVar.eum.adA();
            aVar.eum.setController(this.eLZ);
            aVar.eum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eOI != null && (view2 instanceof EmotionView)) {
                        d.this.eOI.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.czg = (TextView) view.findViewById(d.h.tv_more);
            aj.i(aVar.czg, d.e.cp_cont_d);
            aVar.czg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eOI != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.u(d.this.ceO)) {
                            for (EmotionImageData emotionImageData : d.this.ceO) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        d.this.eOI.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.ceO.size()) {
                aVar.eum.getLayoutParams().width = this.eOH;
                aVar.eum.getLayoutParams().height = this.eOH;
                aVar.eum.reset();
                aVar.eum.setTag(d.h.iv_emotion, null);
                EmotionImageData emotionImageData = this.ceO.get(i);
                if (emotionImageData != null) {
                    aVar.eum.a(emotionImageData);
                    if (this.eue != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eue.add(emotionImageData.getThumbUrl() + aVar.eum.getLoadProcType());
                    }
                }
                aVar.eum.setVisibility(0);
                aVar.czg.setVisibility(8);
            } else if (i == this.ceO.size()) {
                aVar.czg.getLayoutParams().width = this.eOH;
                aVar.czg.getLayoutParams().height = this.eOH;
                aVar.eum.setVisibility(8);
                aVar.czg.setVisibility(0);
            }
        }
        return view;
    }

    public void pC(int i) {
        if (this.eOH != i) {
            this.eOH = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.eLZ = aVar;
    }

    public void a(c.a aVar) {
        this.eOI = aVar;
    }

    /* loaded from: classes.dex */
    class a {
        TextView czg;
        EmotionView eum;

        a() {
        }
    }

    public void aLQ() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eue != null) {
                    for (String str : d.this.eue) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.DT().gf(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
