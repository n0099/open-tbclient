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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> fhG;
    private Set<String> hDl = new HashSet();
    private EmotionView.a hYi;
    private int hZl;
    private PbEmotionBar.a hZm;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fhG)) {
            return 0;
        }
        return this.fhG.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fhG = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0489a c0489a;
        if (view == null) {
            c0489a = new C0489a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0489a.hDt = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0489a.hDt.bfS();
            c0489a.hDt.setController(this.hYi);
            c0489a.hDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hZm != null && (view2 instanceof EmotionView)) {
                        a.this.hZm.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0489a.fGA = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0489a.fGA, (int) R.color.cp_cont_d);
            c0489a.fGA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hZm != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.fhG)) {
                            for (EmotionImageData emotionImageData : a.this.fhG) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hZm.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0489a);
        } else {
            c0489a = (C0489a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.fhG.size()) {
                c0489a.hDt.getLayoutParams().width = this.hZl;
                c0489a.hDt.getLayoutParams().height = this.hZl;
                c0489a.hDt.reset();
                c0489a.hDt.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.fhG.get(i);
                if (emotionImageData != null) {
                    c0489a.hDt.a(emotionImageData);
                    if (this.hDl != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hDl.add(emotionImageData.getThumbUrl() + c0489a.hDt.getLoadProcType());
                    }
                }
                c0489a.hDt.setVisibility(0);
                c0489a.fGA.setVisibility(8);
            } else if (i == this.fhG.size()) {
                c0489a.fGA.getLayoutParams().width = this.hZl;
                c0489a.fGA.getLayoutParams().height = this.hZl;
                c0489a.hDt.setVisibility(8);
                c0489a.fGA.setVisibility(0);
            }
        }
        return view;
    }

    public void wU(int i) {
        if (this.hZl != i) {
            this.hZl = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hYi = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hZm = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0489a {
        TextView fGA;
        EmotionView hDt;

        C0489a() {
        }
    }

    public void bOF() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hDl != null) {
                    for (String str : a.this.hDl) {
                        if (!TextUtils.isEmpty(str)) {
                            c.avu().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
