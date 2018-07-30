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
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> cVu;
    private EmotionView.a fHK;
    private int fIN;
    private PbEmotionBar.a fIO;
    private Set<String> fno = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.cVu)) {
            return 0;
        }
        return this.cVu.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cVu = list;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0212a.fnw = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0212a.fnw.apC();
            c0212a.fnw.setController(this.fHK);
            c0212a.fnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fIO != null && (view2 instanceof EmotionView)) {
                        a.this.fIO.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0212a.dwo = (TextView) view.findViewById(d.g.tv_more);
            am.h(c0212a.dwo, d.C0140d.cp_cont_d);
            c0212a.dwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fIO != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!w.z(a.this.cVu)) {
                            for (EmotionImageData emotionImageData : a.this.cVu) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fIO.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0212a);
        } else {
            c0212a = (C0212a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cVu.size()) {
                c0212a.fnw.getLayoutParams().width = this.fIN;
                c0212a.fnw.getLayoutParams().height = this.fIN;
                c0212a.fnw.reset();
                c0212a.fnw.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cVu.get(i);
                if (emotionImageData != null) {
                    c0212a.fnw.a(emotionImageData);
                    if (this.fno != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fno.add(emotionImageData.getThumbUrl() + c0212a.fnw.getLoadProcType());
                    }
                }
                c0212a.fnw.setVisibility(0);
                c0212a.dwo.setVisibility(8);
            } else if (i == this.cVu.size()) {
                c0212a.dwo.getLayoutParams().width = this.fIN;
                c0212a.dwo.getLayoutParams().height = this.fIN;
                c0212a.fnw.setVisibility(8);
                c0212a.dwo.setVisibility(0);
            }
        }
        return view;
    }

    public void qR(int i) {
        if (this.fIN != i) {
            this.fIN = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fHK = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fIO = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0212a {
        TextView dwo;
        EmotionView fnw;

        C0212a() {
        }
    }

    public void aXM() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fno != null) {
                    for (String str : a.this.fno) {
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
