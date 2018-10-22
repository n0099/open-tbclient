package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> djt;
    private Set<String> fCj = new HashSet();
    private EmotionView.a fWK;
    private int fXN;
    private PbEmotionBar.a fXO;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.djt)) {
            return 0;
        }
        return this.djt.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.djt = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0251a c0251a;
        if (view == null) {
            c0251a = new C0251a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0251a.fCr = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0251a.fCr.auN();
            c0251a.fCr.setController(this.fWK);
            c0251a.fCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fXO != null && (view2 instanceof EmotionView)) {
                        a.this.fXO.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0251a.dKV = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0251a.dKV, e.d.cp_cont_d);
            c0251a.dKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fXO != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.J(a.this.djt)) {
                            for (EmotionImageData emotionImageData : a.this.djt) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fXO.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0251a);
        } else {
            c0251a = (C0251a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.djt.size()) {
                c0251a.fCr.getLayoutParams().width = this.fXN;
                c0251a.fCr.getLayoutParams().height = this.fXN;
                c0251a.fCr.reset();
                c0251a.fCr.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.djt.get(i);
                if (emotionImageData != null) {
                    c0251a.fCr.a(emotionImageData);
                    if (this.fCj != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fCj.add(emotionImageData.getThumbUrl() + c0251a.fCr.getLoadProcType());
                    }
                }
                c0251a.fCr.setVisibility(0);
                c0251a.dKV.setVisibility(8);
            } else if (i == this.djt.size()) {
                c0251a.dKV.getLayoutParams().width = this.fXN;
                c0251a.dKV.getLayoutParams().height = this.fXN;
                c0251a.fCr.setVisibility(8);
                c0251a.dKV.setVisibility(0);
            }
        }
        return view;
    }

    public void rP(int i) {
        if (this.fXN != i) {
            this.fXN = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fWK = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fXO = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0251a {
        TextView dKV;
        EmotionView fCr;

        C0251a() {
        }
    }

    public void bdh() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fCj != null) {
                    for (String str : a.this.fCj) {
                        if (!TextUtils.isEmpty(str)) {
                            c.Me().hM(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
