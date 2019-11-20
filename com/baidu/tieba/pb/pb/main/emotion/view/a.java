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
    private List<EmotionImageData> fgP;
    private Set<String> hCu = new HashSet();
    private EmotionView.a hXr;
    private int hYu;
    private PbEmotionBar.a hYv;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fgP)) {
            return 0;
        }
        return this.fgP.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fgP = list;
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
            c0489a.hCC = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0489a.hCC.bfQ();
            c0489a.hCC.setController(this.hXr);
            c0489a.hCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hYv != null && (view2 instanceof EmotionView)) {
                        a.this.hYv.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0489a.fFJ = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0489a.fFJ, (int) R.color.cp_cont_d);
            c0489a.fFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hYv != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.fgP)) {
                            for (EmotionImageData emotionImageData : a.this.fgP) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hYv.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0489a);
        } else {
            c0489a = (C0489a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.fgP.size()) {
                c0489a.hCC.getLayoutParams().width = this.hYu;
                c0489a.hCC.getLayoutParams().height = this.hYu;
                c0489a.hCC.reset();
                c0489a.hCC.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.fgP.get(i);
                if (emotionImageData != null) {
                    c0489a.hCC.a(emotionImageData);
                    if (this.hCu != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hCu.add(emotionImageData.getThumbUrl() + c0489a.hCC.getLoadProcType());
                    }
                }
                c0489a.hCC.setVisibility(0);
                c0489a.fFJ.setVisibility(8);
            } else if (i == this.fgP.size()) {
                c0489a.fFJ.getLayoutParams().width = this.hYu;
                c0489a.fFJ.getLayoutParams().height = this.hYu;
                c0489a.hCC.setVisibility(8);
                c0489a.fFJ.setVisibility(0);
            }
        }
        return view;
    }

    public void wT(int i) {
        if (this.hYu != i) {
            this.hYu = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hXr = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hYv = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0489a {
        TextView fFJ;
        EmotionView hCC;

        C0489a() {
        }
    }

    public void bOD() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hCu != null) {
                    for (String str : a.this.hCu) {
                        if (!TextUtils.isEmpty(str)) {
                            c.avs().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
