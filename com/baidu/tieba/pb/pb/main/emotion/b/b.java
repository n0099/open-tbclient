package com.baidu.tieba.pb.pb.main.emotion.b;

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
import com.baidu.tieba.pb.pb.main.emotion.b.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> cvp;
    private Set<String> eIV = new HashSet();
    private EmotionView.a fdI;
    private int feJ;
    private a.InterfaceC0116a feK;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cvp)) {
            return 0;
        }
        return this.cvp.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cvp = list;
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
            aVar.eJd = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.eJd.ahG();
            aVar.eJd.setController(this.fdI);
            aVar.eJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.feK != null && (view2 instanceof EmotionView)) {
                        b.this.feK.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.cQy = (TextView) view.findViewById(d.g.tv_more);
            aj.i(aVar.cQy, d.C0082d.cp_cont_d);
            aVar.cQy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.feK != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.w(b.this.cvp)) {
                            for (EmotionImageData emotionImageData : b.this.cvp) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.feK.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cvp.size()) {
                aVar.eJd.getLayoutParams().width = this.feJ;
                aVar.eJd.getLayoutParams().height = this.feJ;
                aVar.eJd.reset();
                aVar.eJd.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cvp.get(i);
                if (emotionImageData != null) {
                    aVar.eJd.a(emotionImageData);
                    if (this.eIV != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eIV.add(emotionImageData.getThumbUrl() + aVar.eJd.getLoadProcType());
                    }
                }
                aVar.eJd.setVisibility(0);
                aVar.cQy.setVisibility(8);
            } else if (i == this.cvp.size()) {
                aVar.cQy.getLayoutParams().width = this.feJ;
                aVar.cQy.getLayoutParams().height = this.feJ;
                aVar.eJd.setVisibility(8);
                aVar.cQy.setVisibility(0);
            }
        }
        return view;
    }

    public void qi(int i) {
        if (this.feJ != i) {
            this.feJ = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fdI = aVar;
    }

    public void a(a.InterfaceC0116a interfaceC0116a) {
        this.feK = interfaceC0116a;
    }

    /* loaded from: classes.dex */
    class a {
        TextView cQy;
        EmotionView eJd;

        a() {
        }
    }

    public void aPG() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.eIV != null) {
                    for (String str : b.this.eIV) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Ez().gq(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
