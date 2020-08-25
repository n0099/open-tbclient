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
    private List<EmotionImageData> hFa;
    private EmotionView.a kOr;
    private int kPw;
    private PbEmotionBar.a kPx;
    private Set<String> kps = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.hFa)) {
            return 0;
        }
        return this.hFa.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hFa = list;
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
            c0773a.kpA = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0773a.kpA.chH();
            c0773a.kpA.setController(this.kOr);
            c0773a.kpA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kPx != null && (view2 instanceof EmotionView)) {
                        a.this.kPx.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0773a.igT = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0773a.igT, R.color.cp_cont_d);
            c0773a.igT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kPx != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.hFa)) {
                            for (EmotionImageData emotionImageData : a.this.hFa) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.kPx.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0773a);
        } else {
            c0773a = (C0773a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.hFa.size()) {
                c0773a.kpA.getLayoutParams().width = this.kPw;
                c0773a.kpA.getLayoutParams().height = this.kPw;
                c0773a.kpA.reset();
                c0773a.kpA.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.hFa.get(i);
                if (emotionImageData != null) {
                    c0773a.kpA.a(emotionImageData);
                    if (this.kps != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.kps.add(emotionImageData.getThumbUrl() + c0773a.kpA.getLoadProcType());
                    }
                }
                c0773a.kpA.setVisibility(0);
                c0773a.igT.setVisibility(8);
            } else if (i == this.hFa.size()) {
                c0773a.igT.getLayoutParams().width = this.kPw;
                c0773a.igT.getLayoutParams().height = this.kPw;
                c0773a.kpA.setVisibility(8);
                c0773a.igT.setVisibility(0);
            }
        }
        return view;
    }

    public void EA(int i) {
        if (this.kPw != i) {
            this.kPw = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.kOr = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.kPx = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C0773a {
        TextView igT;
        EmotionView kpA;

        C0773a() {
        }
    }

    public void cTk() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.kps != null) {
                    for (String str : a.this.kps) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bsW().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
