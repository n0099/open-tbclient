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
    private List<EmotionImageData> feW;
    private Set<String> hEE = new HashSet();
    private EmotionView.a hZA;
    private int iaD;
    private PbEmotionBar.a iaE;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.feW)) {
            return 0;
        }
        return this.feW.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.feW = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0395a c0395a;
        if (view == null) {
            c0395a = new C0395a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0395a.hEM = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0395a.hEM.bia();
            c0395a.hEM.setController(this.hZA);
            c0395a.hEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iaE != null && (view2 instanceof EmotionView)) {
                        a.this.iaE.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0395a.fHl = (TextView) view.findViewById(R.id.tv_more);
            am.j(c0395a.fHl, R.color.cp_cont_d);
            c0395a.fHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iaE != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.aa(a.this.feW)) {
                            for (EmotionImageData emotionImageData : a.this.feW) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iaE.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0395a);
        } else {
            c0395a = (C0395a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.feW.size()) {
                c0395a.hEM.getLayoutParams().width = this.iaD;
                c0395a.hEM.getLayoutParams().height = this.iaD;
                c0395a.hEM.reset();
                c0395a.hEM.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.feW.get(i);
                if (emotionImageData != null) {
                    c0395a.hEM.a(emotionImageData);
                    if (this.hEE != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hEE.add(emotionImageData.getThumbUrl() + c0395a.hEM.getLoadProcType());
                    }
                }
                c0395a.hEM.setVisibility(0);
                c0395a.fHl.setVisibility(8);
            } else if (i == this.feW.size()) {
                c0395a.fHl.getLayoutParams().width = this.iaD;
                c0395a.fHl.getLayoutParams().height = this.iaD;
                c0395a.hEM.setVisibility(8);
                c0395a.fHl.setVisibility(0);
            }
        }
        return view;
    }

    public void yo(int i) {
        if (this.iaD != i) {
            this.iaD = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hZA = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iaE = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0395a {
        TextView fHl;
        EmotionView hEM;

        C0395a() {
        }
    }

    public void bRH() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hEE != null) {
                    for (String str : a.this.hEE) {
                        if (!TextUtils.isEmpty(str)) {
                            c.atK().qQ(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
