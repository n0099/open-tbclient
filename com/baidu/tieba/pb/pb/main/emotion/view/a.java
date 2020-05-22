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
    private List<EmotionImageData> gZB;
    private EmotionView.a jUQ;
    private int jVV;
    private PbEmotionBar.a jVW;
    private Set<String> jwX = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gZB)) {
            return 0;
        }
        return this.gZB.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gZB = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0693a c0693a;
        if (view == null) {
            c0693a = new C0693a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0693a.jxf = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0693a.jxf.bQT();
            c0693a.jxf.setController(this.jUQ);
            c0693a.jxf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jVW != null && (view2 instanceof EmotionView)) {
                        a.this.jVW.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0693a.hyP = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0693a.hyP, (int) R.color.cp_cont_d);
            c0693a.hyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jVW != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gZB)) {
                            for (EmotionImageData emotionImageData : a.this.gZB) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.jVW.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0693a);
        } else {
            c0693a = (C0693a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gZB.size()) {
                c0693a.jxf.getLayoutParams().width = this.jVV;
                c0693a.jxf.getLayoutParams().height = this.jVV;
                c0693a.jxf.reset();
                c0693a.jxf.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gZB.get(i);
                if (emotionImageData != null) {
                    c0693a.jxf.a(emotionImageData);
                    if (this.jwX != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.jwX.add(emotionImageData.getThumbUrl() + c0693a.jxf.getLoadProcType());
                    }
                }
                c0693a.jxf.setVisibility(0);
                c0693a.hyP.setVisibility(8);
            } else if (i == this.gZB.size()) {
                c0693a.hyP.getLayoutParams().width = this.jVV;
                c0693a.hyP.getLayoutParams().height = this.jVV;
                c0693a.jxf.setVisibility(8);
                c0693a.hyP.setVisibility(0);
            }
        }
        return view;
    }

    public void AD(int i) {
        if (this.jVV != i) {
            this.jVV = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.jUQ = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.jVW = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0693a {
        TextView hyP;
        EmotionView jxf;

        C0693a() {
        }
    }

    public void cAe() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.jwX != null) {
                    for (String str : a.this.jwX) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bet().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
