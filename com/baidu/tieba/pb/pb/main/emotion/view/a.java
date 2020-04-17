package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> gKJ;
    private EmotionView.a jDn;
    private int jEs;
    private PbEmotionBar.a jEt;
    private Set<String> jhQ = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gKJ)) {
            return 0;
        }
        return this.gKJ.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gKJ = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0619a c0619a;
        if (view == null) {
            c0619a = new C0619a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0619a.jhY = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0619a.jhY.bKz();
            c0619a.jhY.setController(this.jDn);
            c0619a.jhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jEt != null && (view2 instanceof EmotionView)) {
                        a.this.jEt.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0619a.hjV = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0619a.hjV, (int) R.color.cp_cont_d);
            c0619a.hjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jEt != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gKJ)) {
                            for (EmotionImageData emotionImageData : a.this.gKJ) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.jEt.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0619a);
        } else {
            c0619a = (C0619a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gKJ.size()) {
                c0619a.jhY.getLayoutParams().width = this.jEs;
                c0619a.jhY.getLayoutParams().height = this.jEs;
                c0619a.jhY.reset();
                c0619a.jhY.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gKJ.get(i);
                if (emotionImageData != null) {
                    c0619a.jhY.a(emotionImageData);
                    if (this.jhQ != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.jhQ.add(emotionImageData.getThumbUrl() + c0619a.jhY.getLoadProcType());
                    }
                }
                c0619a.jhY.setVisibility(0);
                c0619a.hjV.setVisibility(8);
            } else if (i == this.gKJ.size()) {
                c0619a.hjV.getLayoutParams().width = this.jEs;
                c0619a.hjV.getLayoutParams().height = this.jEs;
                c0619a.jhY.setVisibility(8);
                c0619a.hjV.setVisibility(0);
            }
        }
        return view;
    }

    public void zS(int i) {
        if (this.jEs != i) {
            this.jEs = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.jDn = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.jEt = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0619a {
        TextView hjV;
        EmotionView jhY;

        C0619a() {
        }
    }

    public void ctE() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.jhQ != null) {
                    for (String str : a.this.jhQ) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aYm().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
