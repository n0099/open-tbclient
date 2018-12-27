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
    private List<EmotionImageData> dtO;
    private Set<String> fNo = new HashSet();
    private EmotionView.a ghS;
    private int giW;
    private PbEmotionBar.a giX;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dtO)) {
            return 0;
        }
        return this.dtO.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dtO = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0289a c0289a;
        if (view == null) {
            c0289a = new C0289a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0289a.fNw = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0289a.fNw.awL();
            c0289a.fNw.setController(this.ghS);
            c0289a.fNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.giX != null && (view2 instanceof EmotionView)) {
                        a.this.giX.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0289a.dVt = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0289a.dVt, e.d.cp_cont_d);
            c0289a.dVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.giX != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.I(a.this.dtO)) {
                            for (EmotionImageData emotionImageData : a.this.dtO) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.giX.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0289a);
        } else {
            c0289a = (C0289a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.dtO.size()) {
                c0289a.fNw.getLayoutParams().width = this.giW;
                c0289a.fNw.getLayoutParams().height = this.giW;
                c0289a.fNw.reset();
                c0289a.fNw.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.dtO.get(i);
                if (emotionImageData != null) {
                    c0289a.fNw.a(emotionImageData);
                    if (this.fNo != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fNo.add(emotionImageData.getThumbUrl() + c0289a.fNw.getLoadProcType());
                    }
                }
                c0289a.fNw.setVisibility(0);
                c0289a.dVt.setVisibility(8);
            } else if (i == this.dtO.size()) {
                c0289a.dVt.getLayoutParams().width = this.giW;
                c0289a.dVt.getLayoutParams().height = this.giW;
                c0289a.fNw.setVisibility(8);
                c0289a.dVt.setVisibility(0);
            }
        }
        return view;
    }

    public void sP(int i) {
        if (this.giW != i) {
            this.giW = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.ghS = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.giX = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0289a {
        TextView dVt;
        EmotionView fNw;

        C0289a() {
        }
    }

    public void bfi() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fNo != null) {
                    for (String str : a.this.fNo) {
                        if (!TextUtils.isEmpty(str)) {
                            c.Nv().ig(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
