package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private List<EmotionImageData> hlY;
    private Set<String> jRw = new HashSet();
    private EmotionView.a kpM;
    private int kqR;
    private PbEmotionBar.a kqS;

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.hlY)) {
            return 0;
        }
        return this.hlY.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hlY = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0710a c0710a;
        if (view == null) {
            c0710a = new C0710a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0710a.jRE = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0710a.jRE.bTR();
            c0710a.jRE.setController(this.kpM);
            c0710a.jRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kqS != null && (view2 instanceof EmotionView)) {
                        a.this.kqS.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0710a.hMK = (TextView) view.findViewById(R.id.tv_more);
            an.setViewTextColor(c0710a.hMK, (int) R.color.cp_cont_d);
            c0710a.hMK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kqS != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!w.isEmpty(a.this.hlY)) {
                            for (EmotionImageData emotionImageData : a.this.hlY) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.kqS.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0710a);
        } else {
            c0710a = (C0710a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.hlY.size()) {
                c0710a.jRE.getLayoutParams().width = this.kqR;
                c0710a.jRE.getLayoutParams().height = this.kqR;
                c0710a.jRE.reset();
                c0710a.jRE.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.hlY.get(i);
                if (emotionImageData != null) {
                    c0710a.jRE.a(emotionImageData);
                    if (this.jRw != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.jRw.add(emotionImageData.getThumbUrl() + c0710a.jRE.getLoadProcType());
                    }
                }
                c0710a.jRE.setVisibility(0);
                c0710a.hMK.setVisibility(8);
            } else if (i == this.hlY.size()) {
                c0710a.hMK.getLayoutParams().width = this.kqR;
                c0710a.hMK.getLayoutParams().height = this.kqR;
                c0710a.jRE.setVisibility(8);
                c0710a.hMK.setVisibility(0);
            }
        }
        return view;
    }

    public void BH(int i) {
        if (this.kqR != i) {
            this.kqR = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.kpM = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.kqS = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0710a {
        TextView hMK;
        EmotionView jRE;

        C0710a() {
        }
    }

    public void cEL() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.jRw != null) {
                    for (String str : a.this.jRw) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bgz().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
