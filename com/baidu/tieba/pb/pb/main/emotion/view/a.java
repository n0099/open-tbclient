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
    private List<EmotionImageData> ibc;
    private Set<String> kNk = new HashSet();
    private EmotionView.a lmn;
    private int lnt;
    private PbEmotionBar.a lnu;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.ibc)) {
            return 0;
        }
        return this.ibc.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.ibc = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0788a c0788a;
        if (view == null) {
            c0788a = new C0788a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0788a.kNs = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0788a.kNs.cot();
            c0788a.kNs.setController(this.lmn);
            c0788a.kNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lnu != null && (view2 instanceof EmotionView)) {
                        a.this.lnu.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0788a.iCU = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0788a.iCU, R.color.cp_cont_d);
            c0788a.iCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lnu != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.ibc)) {
                            for (EmotionImageData emotionImageData : a.this.ibc) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lnu.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0788a);
        } else {
            c0788a = (C0788a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.ibc.size()) {
                c0788a.kNs.getLayoutParams().width = this.lnt;
                c0788a.kNs.getLayoutParams().height = this.lnt;
                c0788a.kNs.reset();
                c0788a.kNs.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.ibc.get(i);
                if (emotionImageData != null) {
                    c0788a.kNs.a(emotionImageData);
                    if (this.kNk != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.kNk.add(emotionImageData.getThumbUrl() + c0788a.kNs.getLoadProcType());
                    }
                }
                c0788a.kNs.setVisibility(0);
                c0788a.iCU.setVisibility(8);
            } else if (i == this.ibc.size()) {
                c0788a.iCU.getLayoutParams().width = this.lnt;
                c0788a.iCU.getLayoutParams().height = this.lnt;
                c0788a.kNs.setVisibility(8);
                c0788a.iCU.setVisibility(0);
            }
        }
        return view;
    }

    public void FH(int i) {
        if (this.lnt != i) {
            this.lnt = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lmn = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lnu = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0788a {
        TextView iCU;
        EmotionView kNs;

        C0788a() {
        }
    }

    public void daz() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.kNk != null) {
                    for (String str : a.this.kNk) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bwL().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
