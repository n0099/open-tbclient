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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> drE;
    private Set<String> fBY = new HashSet();
    private EmotionView.a fWT;
    private int fXW;
    private a.InterfaceC0211a fXX;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.drE)) {
            return 0;
        }
        return this.drE.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.drE = list;
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
            aVar.fCg = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.fCg.arl();
            aVar.fCg.setController(this.fWT);
            aVar.fCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fXX != null && (view2 instanceof EmotionView)) {
                        b.this.fXX.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.dNs = (TextView) view.findViewById(d.g.tv_more);
            aj.r(aVar.dNs, d.C0141d.cp_cont_d);
            aVar.dNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fXX != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.E(b.this.drE)) {
                            for (EmotionImageData emotionImageData : b.this.drE) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.fXX.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.drE.size()) {
                aVar.fCg.getLayoutParams().width = this.fXW;
                aVar.fCg.getLayoutParams().height = this.fXW;
                aVar.fCg.reset();
                aVar.fCg.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.drE.get(i);
                if (emotionImageData != null) {
                    aVar.fCg.a(emotionImageData);
                    if (this.fBY != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fBY.add(emotionImageData.getThumbUrl() + aVar.fCg.getLoadProcType());
                    }
                }
                aVar.fCg.setVisibility(0);
                aVar.dNs.setVisibility(8);
            } else if (i == this.drE.size()) {
                aVar.dNs.getLayoutParams().width = this.fXW;
                aVar.dNs.getLayoutParams().height = this.fXW;
                aVar.fCg.setVisibility(8);
                aVar.dNs.setVisibility(0);
            }
        }
        return view;
    }

    public void tg(int i) {
        if (this.fXW != i) {
            this.fXW = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fWT = aVar;
    }

    public void a(a.InterfaceC0211a interfaceC0211a) {
        this.fXX = interfaceC0211a;
    }

    /* loaded from: classes2.dex */
    class a {
        TextView dNs;
        EmotionView fCg;

        a() {
        }
    }

    public void aYS() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.fBY != null) {
                    for (String str : b.this.fBY) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Mx().gN(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
