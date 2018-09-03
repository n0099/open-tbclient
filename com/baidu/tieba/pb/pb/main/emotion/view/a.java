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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> cVq;
    private EmotionView.a fHD;
    private int fIG;
    private PbEmotionBar.a fIH;
    private Set<String> fni = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.cVq)) {
            return 0;
        }
        return this.cVq.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cVq = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0212a c0212a;
        if (view == null) {
            c0212a = new C0212a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0212a.fnq = (EmotionView) view.findViewById(f.g.iv_emotion);
            c0212a.fnq.apC();
            c0212a.fnq.setController(this.fHD);
            c0212a.fnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fIH != null && (view2 instanceof EmotionView)) {
                        a.this.fIH.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0212a.dwl = (TextView) view.findViewById(f.g.tv_more);
            am.h(c0212a.dwl, f.d.cp_cont_d);
            c0212a.dwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fIH != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!w.z(a.this.cVq)) {
                            for (EmotionImageData emotionImageData : a.this.cVq) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fIH.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0212a);
        } else {
            c0212a = (C0212a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cVq.size()) {
                c0212a.fnq.getLayoutParams().width = this.fIG;
                c0212a.fnq.getLayoutParams().height = this.fIG;
                c0212a.fnq.reset();
                c0212a.fnq.setTag(f.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cVq.get(i);
                if (emotionImageData != null) {
                    c0212a.fnq.a(emotionImageData);
                    if (this.fni != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fni.add(emotionImageData.getThumbUrl() + c0212a.fnq.getLoadProcType());
                    }
                }
                c0212a.fnq.setVisibility(0);
                c0212a.dwl.setVisibility(8);
            } else if (i == this.cVq.size()) {
                c0212a.dwl.getLayoutParams().width = this.fIG;
                c0212a.dwl.getLayoutParams().height = this.fIG;
                c0212a.fnq.setVisibility(8);
                c0212a.dwl.setVisibility(0);
            }
        }
        return view;
    }

    public void qR(int i) {
        if (this.fIG != i) {
            this.fIG = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fHD = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fIH = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0212a {
        TextView dwl;
        EmotionView fnq;

        C0212a() {
        }
    }

    public void aXI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fni != null) {
                    for (String str : a.this.fni) {
                        if (!TextUtils.isEmpty(str)) {
                            c.IQ().hc(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
