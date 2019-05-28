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
    private List<EmotionImageData> eXI;
    private EmotionView.a hQt;
    private int hRw;
    private PbEmotionBar.a hRx;
    private Set<String> hvD = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.eXI)) {
            return 0;
        }
        return this.eXI.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eXI = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0379a c0379a;
        if (view == null) {
            c0379a = new C0379a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0379a.hvL = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0379a.hvL.bff();
            c0379a.hvL.setController(this.hQt);
            c0379a.hvL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hRx != null && (view2 instanceof EmotionView)) {
                        a.this.hRx.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0379a.fzK = (TextView) view.findViewById(R.id.tv_more);
            al.j(c0379a.fzK, R.color.cp_cont_d);
            c0379a.fzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hRx != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.aa(a.this.eXI)) {
                            for (EmotionImageData emotionImageData : a.this.eXI) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hRx.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0379a);
        } else {
            c0379a = (C0379a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.eXI.size()) {
                c0379a.hvL.getLayoutParams().width = this.hRw;
                c0379a.hvL.getLayoutParams().height = this.hRw;
                c0379a.hvL.reset();
                c0379a.hvL.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.eXI.get(i);
                if (emotionImageData != null) {
                    c0379a.hvL.a(emotionImageData);
                    if (this.hvD != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hvD.add(emotionImageData.getThumbUrl() + c0379a.hvL.getLoadProcType());
                    }
                }
                c0379a.hvL.setVisibility(0);
                c0379a.fzK.setVisibility(8);
            } else if (i == this.eXI.size()) {
                c0379a.fzK.getLayoutParams().width = this.hRw;
                c0379a.fzK.getLayoutParams().height = this.hRw;
                c0379a.hvL.setVisibility(8);
                c0379a.fzK.setVisibility(0);
            }
        }
        return view;
    }

    public void xF(int i) {
        if (this.hRw != i) {
            this.hRw = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hQt = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hRx = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0379a {
        TextView fzK;
        EmotionView hvL;

        C0379a() {
        }
    }

    public void bNV() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hvD != null) {
                    for (String str : a.this.hvD) {
                        if (!TextUtils.isEmpty(str)) {
                            c.asp().qp(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
