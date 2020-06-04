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
    private List<EmotionImageData> gZM;
    private EmotionView.a jVW;
    private int jXb;
    private PbEmotionBar.a jXc;
    private Set<String> jyd = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gZM)) {
            return 0;
        }
        return this.gZM.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gZM = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0694a c0694a;
        if (view == null) {
            c0694a = new C0694a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0694a.jyl = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0694a.jyl.bQV();
            c0694a.jyl.setController(this.jVW);
            c0694a.jyl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jXc != null && (view2 instanceof EmotionView)) {
                        a.this.jXc.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0694a.hzC = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0694a.hzC, (int) R.color.cp_cont_d);
            c0694a.hzC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jXc != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gZM)) {
                            for (EmotionImageData emotionImageData : a.this.gZM) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.jXc.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0694a);
        } else {
            c0694a = (C0694a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gZM.size()) {
                c0694a.jyl.getLayoutParams().width = this.jXb;
                c0694a.jyl.getLayoutParams().height = this.jXb;
                c0694a.jyl.reset();
                c0694a.jyl.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gZM.get(i);
                if (emotionImageData != null) {
                    c0694a.jyl.a(emotionImageData);
                    if (this.jyd != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.jyd.add(emotionImageData.getThumbUrl() + c0694a.jyl.getLoadProcType());
                    }
                }
                c0694a.jyl.setVisibility(0);
                c0694a.hzC.setVisibility(8);
            } else if (i == this.gZM.size()) {
                c0694a.hzC.getLayoutParams().width = this.jXb;
                c0694a.hzC.getLayoutParams().height = this.jXb;
                c0694a.jyl.setVisibility(8);
                c0694a.hzC.setVisibility(0);
            }
        }
        return view;
    }

    public void AF(int i) {
        if (this.jXb != i) {
            this.jXb = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.jVW = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.jXc = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0694a {
        TextView hzC;
        EmotionView jyl;

        C0694a() {
        }
    }

    public void cAv() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.jyd != null) {
                    for (String str : a.this.jyd) {
                        if (!TextUtils.isEmpty(str)) {
                            c.beu().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
