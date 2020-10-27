package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> inE;
    private Set<String> kZH = new HashSet();
    private EmotionView.a lyR;
    private int lzW;
    private PbEmotionBar.a lzX;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.inE)) {
            return 0;
        }
        return this.inE.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.inE = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0803a c0803a;
        if (view == null) {
            c0803a = new C0803a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0803a.kZP = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0803a.kZP.crA();
            c0803a.kZP.setController(this.lyR);
            c0803a.kZP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lzX != null && (view2 instanceof EmotionView)) {
                        a.this.lzX.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0803a.iPq = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0803a.iPq, R.color.cp_cont_d);
            c0803a.iPq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lzX != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.inE)) {
                            for (EmotionImageData emotionImageData : a.this.inE) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lzX.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0803a);
        } else {
            c0803a = (C0803a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.inE.size()) {
                c0803a.kZP.getLayoutParams().width = this.lzW;
                c0803a.kZP.getLayoutParams().height = this.lzW;
                c0803a.kZP.reset();
                c0803a.kZP.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.inE.get(i);
                if (emotionImageData != null) {
                    c0803a.kZP.a(emotionImageData);
                    if (this.kZH != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.kZH.add(emotionImageData.getThumbUrl() + c0803a.kZP.getLoadProcType());
                    }
                }
                c0803a.kZP.setVisibility(0);
                c0803a.iPq.setVisibility(8);
            } else if (i == this.inE.size()) {
                c0803a.iPq.getLayoutParams().width = this.lzW;
                c0803a.iPq.getLayoutParams().height = this.lzW;
                c0803a.kZP.setVisibility(8);
                c0803a.iPq.setVisibility(0);
            }
        }
        return view;
    }

    public void Ga(int i) {
        if (this.lzW != i) {
            this.lzW = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lyR = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lzX = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0803a {
        TextView iPq;
        EmotionView kZP;

        C0803a() {
        }
    }

    public void ddH() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.kZH != null) {
                    for (String str : a.this.kZH) {
                        if (!TextUtils.isEmpty(str)) {
                            c.byE().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
