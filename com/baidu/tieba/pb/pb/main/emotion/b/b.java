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
    private List<EmotionImageData> drB;
    private Set<String> fBI = new HashSet();
    private EmotionView.a fWD;
    private int fXG;
    private a.InterfaceC0211a fXH;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.drB)) {
            return 0;
        }
        return this.drB.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.drB = list;
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
            aVar.fBQ = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.fBQ.ark();
            aVar.fBQ.setController(this.fWD);
            aVar.fBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fXH != null && (view2 instanceof EmotionView)) {
                        b.this.fXH.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.dNn = (TextView) view.findViewById(d.g.tv_more);
            aj.r(aVar.dNn, d.C0141d.cp_cont_d);
            aVar.dNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fXH != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.E(b.this.drB)) {
                            for (EmotionImageData emotionImageData : b.this.drB) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.fXH.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.drB.size()) {
                aVar.fBQ.getLayoutParams().width = this.fXG;
                aVar.fBQ.getLayoutParams().height = this.fXG;
                aVar.fBQ.reset();
                aVar.fBQ.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.drB.get(i);
                if (emotionImageData != null) {
                    aVar.fBQ.a(emotionImageData);
                    if (this.fBI != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fBI.add(emotionImageData.getThumbUrl() + aVar.fBQ.getLoadProcType());
                    }
                }
                aVar.fBQ.setVisibility(0);
                aVar.dNn.setVisibility(8);
            } else if (i == this.drB.size()) {
                aVar.dNn.getLayoutParams().width = this.fXG;
                aVar.dNn.getLayoutParams().height = this.fXG;
                aVar.fBQ.setVisibility(8);
                aVar.dNn.setVisibility(0);
            }
        }
        return view;
    }

    public void tg(int i) {
        if (this.fXG != i) {
            this.fXG = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fWD = aVar;
    }

    public void a(a.InterfaceC0211a interfaceC0211a) {
        this.fXH = interfaceC0211a;
    }

    /* loaded from: classes2.dex */
    class a {
        TextView dNn;
        EmotionView fBQ;

        a() {
        }
    }

    public void aYR() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.fBI != null) {
                    for (String str : b.this.fBI) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Mw().gN(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
