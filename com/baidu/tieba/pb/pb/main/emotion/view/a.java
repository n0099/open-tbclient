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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> fVu;
    private EmotionView.a iMq;
    private int iNv;
    private PbEmotionBar.a iNw;
    private Set<String> iqx = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fVu)) {
            return 0;
        }
        return this.fVu.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fVu = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0568a c0568a;
        if (view == null) {
            c0568a = new C0568a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0568a.iqF = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0568a.iqF.bxl();
            c0568a.iqF.setController(this.iMq);
            c0568a.iqF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iNw != null && (view2 instanceof EmotionView)) {
                        a.this.iNw.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0568a.guc = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0568a.guc, (int) R.color.cp_cont_d);
            c0568a.guc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iNw != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.fVu)) {
                            for (EmotionImageData emotionImageData : a.this.fVu) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iNw.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0568a);
        } else {
            c0568a = (C0568a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.fVu.size()) {
                c0568a.iqF.getLayoutParams().width = this.iNv;
                c0568a.iqF.getLayoutParams().height = this.iNv;
                c0568a.iqF.reset();
                c0568a.iqF.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.fVu.get(i);
                if (emotionImageData != null) {
                    c0568a.iqF.a(emotionImageData);
                    if (this.iqx != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.iqx.add(emotionImageData.getThumbUrl() + c0568a.iqF.getLoadProcType());
                    }
                }
                c0568a.iqF.setVisibility(0);
                c0568a.guc.setVisibility(8);
            } else if (i == this.fVu.size()) {
                c0568a.guc.getLayoutParams().width = this.iNv;
                c0568a.guc.getLayoutParams().height = this.iNv;
                c0568a.iqF.setVisibility(8);
                c0568a.guc.setVisibility(0);
            }
        }
        return view;
    }

    public void yY(int i) {
        if (this.iNv != i) {
            this.iNv = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.iMq = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iNw = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0568a {
        TextView guc;
        EmotionView iqF;

        C0568a() {
        }
    }

    public void cfN() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.iqx != null) {
                    for (String str : a.this.iqx) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aMZ().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
