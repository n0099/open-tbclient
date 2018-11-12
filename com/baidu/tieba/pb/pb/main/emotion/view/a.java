package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> dky;
    private Set<String> fDG = new HashSet();
    private EmotionView.a fYj;
    private int fZm;
    private PbEmotionBar.a fZn;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dky)) {
            return 0;
        }
        return this.dky.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dky = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0278a c0278a;
        if (view == null) {
            c0278a = new C0278a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0278a.fDO = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0278a.fDO.aul();
            c0278a.fDO.setController(this.fYj);
            c0278a.fDO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fZn != null && (view2 instanceof EmotionView)) {
                        a.this.fZn.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0278a.dLZ = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0278a.dLZ, e.d.cp_cont_d);
            c0278a.dLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fZn != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.I(a.this.dky)) {
                            for (EmotionImageData emotionImageData : a.this.dky) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fZn.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0278a);
        } else {
            c0278a = (C0278a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.dky.size()) {
                c0278a.fDO.getLayoutParams().width = this.fZm;
                c0278a.fDO.getLayoutParams().height = this.fZm;
                c0278a.fDO.reset();
                c0278a.fDO.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.dky.get(i);
                if (emotionImageData != null) {
                    c0278a.fDO.a(emotionImageData);
                    if (this.fDG != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fDG.add(emotionImageData.getThumbUrl() + c0278a.fDO.getLoadProcType());
                    }
                }
                c0278a.fDO.setVisibility(0);
                c0278a.dLZ.setVisibility(8);
            } else if (i == this.dky.size()) {
                c0278a.dLZ.getLayoutParams().width = this.fZm;
                c0278a.dLZ.getLayoutParams().height = this.fZm;
                c0278a.fDO.setVisibility(8);
                c0278a.dLZ.setVisibility(0);
            }
        }
        return view;
    }

    public void si(int i) {
        if (this.fZm != i) {
            this.fZm = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fYj = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fZn = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0278a {
        TextView dLZ;
        EmotionView fDO;

        C0278a() {
        }
    }

    public void bcG() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fDG != null) {
                    for (String str : a.this.fDG) {
                        if (!TextUtils.isEmpty(str)) {
                            c.Mq().hN(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
