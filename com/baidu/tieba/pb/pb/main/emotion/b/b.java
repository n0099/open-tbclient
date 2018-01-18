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
    private List<EmotionImageData> doz;
    private EmotionView.a fTh;
    private int fUk;
    private a.InterfaceC0141a fUl;
    private Set<String> fxZ = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.doz)) {
            return 0;
        }
        return this.doz.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.doz = list;
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
            aVar.fyh = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.fyh.aqq();
            aVar.fyh.setController(this.fTh);
            aVar.fyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fUl != null && (view2 instanceof EmotionView)) {
                        b.this.fUl.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.dKf = (TextView) view.findViewById(d.g.tv_more);
            aj.r(aVar.dKf, d.C0107d.cp_cont_d);
            aVar.dKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fUl != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.E(b.this.doz)) {
                            for (EmotionImageData emotionImageData : b.this.doz) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.fUl.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.doz.size()) {
                aVar.fyh.getLayoutParams().width = this.fUk;
                aVar.fyh.getLayoutParams().height = this.fUk;
                aVar.fyh.reset();
                aVar.fyh.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.doz.get(i);
                if (emotionImageData != null) {
                    aVar.fyh.a(emotionImageData);
                    if (this.fxZ != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fxZ.add(emotionImageData.getThumbUrl() + aVar.fyh.getLoadProcType());
                    }
                }
                aVar.fyh.setVisibility(0);
                aVar.dKf.setVisibility(8);
            } else if (i == this.doz.size()) {
                aVar.dKf.getLayoutParams().width = this.fUk;
                aVar.dKf.getLayoutParams().height = this.fUk;
                aVar.fyh.setVisibility(8);
                aVar.dKf.setVisibility(0);
            }
        }
        return view;
    }

    public void tb(int i) {
        if (this.fUk != i) {
            this.fUk = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fTh = aVar;
    }

    public void a(a.InterfaceC0141a interfaceC0141a) {
        this.fUl = interfaceC0141a;
    }

    /* loaded from: classes2.dex */
    class a {
        TextView dKf;
        EmotionView fyh;

        a() {
        }
    }

    public void aXe() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.fxZ != null) {
                    for (String str : b.this.fxZ) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.LP().gw(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
