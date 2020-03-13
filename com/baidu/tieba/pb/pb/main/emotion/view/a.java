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
    private List<EmotionImageData> gaS;
    private EmotionView.a iRD;
    private int iSI;
    private PbEmotionBar.a iSJ;
    private Set<String> iwk = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gaS)) {
            return 0;
        }
        return this.gaS.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gaS = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0580a c0580a;
        if (view == null) {
            c0580a = new C0580a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0580a.iws = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0580a.iws.bzS();
            c0580a.iws.setController(this.iRD);
            c0580a.iws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iSJ != null && (view2 instanceof EmotionView)) {
                        a.this.iSJ.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0580a.gzB = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0580a.gzB, (int) R.color.cp_cont_d);
            c0580a.gzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iSJ != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gaS)) {
                            for (EmotionImageData emotionImageData : a.this.gaS) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iSJ.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0580a);
        } else {
            c0580a = (C0580a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gaS.size()) {
                c0580a.iws.getLayoutParams().width = this.iSI;
                c0580a.iws.getLayoutParams().height = this.iSI;
                c0580a.iws.reset();
                c0580a.iws.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gaS.get(i);
                if (emotionImageData != null) {
                    c0580a.iws.a(emotionImageData);
                    if (this.iwk != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.iwk.add(emotionImageData.getThumbUrl() + c0580a.iws.getLoadProcType());
                    }
                }
                c0580a.iws.setVisibility(0);
                c0580a.gzB.setVisibility(8);
            } else if (i == this.gaS.size()) {
                c0580a.gzB.getLayoutParams().width = this.iSI;
                c0580a.gzB.getLayoutParams().height = this.iSI;
                c0580a.iws.setVisibility(8);
                c0580a.gzB.setVisibility(0);
            }
        }
        return view;
    }

    public void zj(int i) {
        if (this.iSI != i) {
            this.iSI = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.iRD = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iSJ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0580a {
        TextView gzB;
        EmotionView iws;

        C0580a() {
        }
    }

    public void ciD() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.iwk != null) {
                    for (String str : a.this.iwk) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aPR().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
