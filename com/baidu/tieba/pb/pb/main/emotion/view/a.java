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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> dbj;
    private EmotionView.a fPj;
    private int fQm;
    private PbEmotionBar.a fQn;
    private Set<String> fuF = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.z(this.dbj)) {
            return 0;
        }
        return this.dbj.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dbj = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0217a c0217a;
        if (view == null) {
            c0217a = new C0217a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0217a.fuN = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0217a.fuN.arq();
            c0217a.fuN.setController(this.fPj);
            c0217a.fuN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fQn != null && (view2 instanceof EmotionView)) {
                        a.this.fQn.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0217a.dCV = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0217a.dCV, e.d.cp_cont_d);
            c0217a.dCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fQn != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.z(a.this.dbj)) {
                            for (EmotionImageData emotionImageData : a.this.dbj) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fQn.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0217a);
        } else {
            c0217a = (C0217a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.dbj.size()) {
                c0217a.fuN.getLayoutParams().width = this.fQm;
                c0217a.fuN.getLayoutParams().height = this.fQm;
                c0217a.fuN.reset();
                c0217a.fuN.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.dbj.get(i);
                if (emotionImageData != null) {
                    c0217a.fuN.a(emotionImageData);
                    if (this.fuF != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fuF.add(emotionImageData.getThumbUrl() + c0217a.fuN.getLoadProcType());
                    }
                }
                c0217a.fuN.setVisibility(0);
                c0217a.dCV.setVisibility(8);
            } else if (i == this.dbj.size()) {
                c0217a.dCV.getLayoutParams().width = this.fQm;
                c0217a.dCV.getLayoutParams().height = this.fQm;
                c0217a.fuN.setVisibility(8);
                c0217a.dCV.setVisibility(0);
            }
        }
        return view;
    }

    public void rs(int i) {
        if (this.fQm != i) {
            this.fQm = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fPj = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fQn = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0217a {
        TextView dCV;
        EmotionView fuN;

        C0217a() {
        }
    }

    public void aZV() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fuF != null) {
                    for (String str : a.this.fuF) {
                        if (!TextUtils.isEmpty(str)) {
                            c.Kg().hy(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
