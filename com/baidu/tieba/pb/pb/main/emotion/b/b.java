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
    private List<EmotionImageData> cvy;
    private Set<String> eJZ = new HashSet();
    private EmotionView.a feJ;
    private int ffK;
    private a.InterfaceC0131a ffL;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cvy)) {
            return 0;
        }
        return this.cvy.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cvy = list;
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
            aVar.eKh = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.eKh.ahO();
            aVar.eKh.setController(this.feJ);
            aVar.eKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ffL != null && (view2 instanceof EmotionView)) {
                        b.this.ffL.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.cQJ = (TextView) view.findViewById(d.g.tv_more);
            aj.i(aVar.cQJ, d.C0096d.cp_cont_d);
            aVar.cQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ffL != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.w(b.this.cvy)) {
                            for (EmotionImageData emotionImageData : b.this.cvy) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.ffL.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cvy.size()) {
                aVar.eKh.getLayoutParams().width = this.ffK;
                aVar.eKh.getLayoutParams().height = this.ffK;
                aVar.eKh.reset();
                aVar.eKh.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cvy.get(i);
                if (emotionImageData != null) {
                    aVar.eKh.a(emotionImageData);
                    if (this.eJZ != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eJZ.add(emotionImageData.getThumbUrl() + aVar.eKh.getLoadProcType());
                    }
                }
                aVar.eKh.setVisibility(0);
                aVar.cQJ.setVisibility(8);
            } else if (i == this.cvy.size()) {
                aVar.cQJ.getLayoutParams().width = this.ffK;
                aVar.cQJ.getLayoutParams().height = this.ffK;
                aVar.eKh.setVisibility(8);
                aVar.cQJ.setVisibility(0);
            }
        }
        return view;
    }

    public void qp(int i) {
        if (this.ffK != i) {
            this.ffK = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.feJ = aVar;
    }

    public void a(a.InterfaceC0131a interfaceC0131a) {
        this.ffL = interfaceC0131a;
    }

    /* loaded from: classes.dex */
    class a {
        TextView cQJ;
        EmotionView eKh;

        a() {
        }
    }

    public void aPP() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.eJZ != null) {
                    for (String str : b.this.eJZ) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.EA().gp(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
