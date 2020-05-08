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
    private List<EmotionImageData> gKP;
    private EmotionView.a jDr;
    private int jEw;
    private PbEmotionBar.a jEx;
    private Set<String> jhU = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gKP)) {
            return 0;
        }
        return this.gKP.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gKP = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0640a c0640a;
        if (view == null) {
            c0640a = new C0640a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0640a.jic = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0640a.jic.bKx();
            c0640a.jic.setController(this.jDr);
            c0640a.jic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jEx != null && (view2 instanceof EmotionView)) {
                        a.this.jEx.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0640a.hkb = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0640a.hkb, (int) R.color.cp_cont_d);
            c0640a.hkb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jEx != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gKP)) {
                            for (EmotionImageData emotionImageData : a.this.gKP) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.jEx.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0640a);
        } else {
            c0640a = (C0640a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gKP.size()) {
                c0640a.jic.getLayoutParams().width = this.jEw;
                c0640a.jic.getLayoutParams().height = this.jEw;
                c0640a.jic.reset();
                c0640a.jic.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gKP.get(i);
                if (emotionImageData != null) {
                    c0640a.jic.a(emotionImageData);
                    if (this.jhU != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.jhU.add(emotionImageData.getThumbUrl() + c0640a.jic.getLoadProcType());
                    }
                }
                c0640a.jic.setVisibility(0);
                c0640a.hkb.setVisibility(8);
            } else if (i == this.gKP.size()) {
                c0640a.hkb.getLayoutParams().width = this.jEw;
                c0640a.hkb.getLayoutParams().height = this.jEw;
                c0640a.jic.setVisibility(8);
                c0640a.hkb.setVisibility(0);
            }
        }
        return view;
    }

    public void zS(int i) {
        if (this.jEw != i) {
            this.jEw = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.jDr = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.jEx = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0640a {
        TextView hkb;
        EmotionView jic;

        C0640a() {
        }
    }

    public void ctB() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.jhU != null) {
                    for (String str : a.this.jhU) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aYk().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
