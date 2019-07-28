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
    private List<EmotionImageData> fcJ;
    private Set<String> hBQ = new HashSet();
    private EmotionView.a hWH;
    private int hXK;
    private PbEmotionBar.a hXL;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.fcJ)) {
            return 0;
        }
        return this.fcJ.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fcJ = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0384a c0384a;
        if (view == null) {
            c0384a = new C0384a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0384a.hBY = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0384a.hBY.bhi();
            c0384a.hBY.setController(this.hWH);
            c0384a.hBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hXL != null && (view2 instanceof EmotionView)) {
                        a.this.hXL.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0384a.fEI = (TextView) view.findViewById(R.id.tv_more);
            am.j(c0384a.fEI, R.color.cp_cont_d);
            c0384a.fEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hXL != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.aa(a.this.fcJ)) {
                            for (EmotionImageData emotionImageData : a.this.fcJ) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hXL.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0384a);
        } else {
            c0384a = (C0384a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.fcJ.size()) {
                c0384a.hBY.getLayoutParams().width = this.hXK;
                c0384a.hBY.getLayoutParams().height = this.hXK;
                c0384a.hBY.reset();
                c0384a.hBY.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.fcJ.get(i);
                if (emotionImageData != null) {
                    c0384a.hBY.a(emotionImageData);
                    if (this.hBQ != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hBQ.add(emotionImageData.getThumbUrl() + c0384a.hBY.getLoadProcType());
                    }
                }
                c0384a.hBY.setVisibility(0);
                c0384a.fEI.setVisibility(8);
            } else if (i == this.fcJ.size()) {
                c0384a.fEI.getLayoutParams().width = this.hXK;
                c0384a.fEI.getLayoutParams().height = this.hXK;
                c0384a.hBY.setVisibility(8);
                c0384a.fEI.setVisibility(0);
            }
        }
        return view;
    }

    public void yj(int i) {
        if (this.hXK != i) {
            this.hXK = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hWH = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hXL = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0384a {
        TextView fEI;
        EmotionView hBY;

        C0384a() {
        }
    }

    public void bQF() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hBQ != null) {
                    for (String str : a.this.hBQ) {
                        if (!TextUtils.isEmpty(str)) {
                            c.atw().qF(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
