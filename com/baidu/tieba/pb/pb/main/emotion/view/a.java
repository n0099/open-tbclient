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
/* loaded from: classes16.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> hFg;
    private EmotionView.a kOy;
    private int kPD;
    private PbEmotionBar.a kPE;
    private Set<String> kpz = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.hFg)) {
            return 0;
        }
        return this.hFg.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hFg = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0773a c0773a;
        if (view == null) {
            c0773a = new C0773a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0773a.kpH = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0773a.kpH.chI();
            c0773a.kpH.setController(this.kOy);
            c0773a.kpH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kPE != null && (view2 instanceof EmotionView)) {
                        a.this.kPE.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0773a.igZ = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0773a.igZ, R.color.cp_cont_d);
            c0773a.igZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kPE != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.hFg)) {
                            for (EmotionImageData emotionImageData : a.this.hFg) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.kPE.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0773a);
        } else {
            c0773a = (C0773a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.hFg.size()) {
                c0773a.kpH.getLayoutParams().width = this.kPD;
                c0773a.kpH.getLayoutParams().height = this.kPD;
                c0773a.kpH.reset();
                c0773a.kpH.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.hFg.get(i);
                if (emotionImageData != null) {
                    c0773a.kpH.a(emotionImageData);
                    if (this.kpz != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.kpz.add(emotionImageData.getThumbUrl() + c0773a.kpH.getLoadProcType());
                    }
                }
                c0773a.kpH.setVisibility(0);
                c0773a.igZ.setVisibility(8);
            } else if (i == this.hFg.size()) {
                c0773a.igZ.getLayoutParams().width = this.kPD;
                c0773a.igZ.getLayoutParams().height = this.kPD;
                c0773a.kpH.setVisibility(8);
                c0773a.igZ.setVisibility(0);
            }
        }
        return view;
    }

    public void EA(int i) {
        if (this.kPD != i) {
            this.kPD = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.kOy = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.kPE = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C0773a {
        TextView igZ;
        EmotionView kpH;

        C0773a() {
        }
    }

    public void cTl() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.kpz != null) {
                    for (String str : a.this.kpz) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bsX().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
