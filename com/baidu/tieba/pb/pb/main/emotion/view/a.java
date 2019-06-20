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
    private EmotionView.a hQu;
    private int hRx;
    private PbEmotionBar.a hRy;
    private Set<String> hvE = new HashSet();

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
            c0379a.hvM = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0379a.hvM.bff();
            c0379a.hvM.setController(this.hQu);
            c0379a.hvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hRy != null && (view2 instanceof EmotionView)) {
                        a.this.hRy.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0379a.fzK = (TextView) view.findViewById(R.id.tv_more);
            al.j(c0379a.fzK, R.color.cp_cont_d);
            c0379a.fzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hRy != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.aa(a.this.eXI)) {
                            for (EmotionImageData emotionImageData : a.this.eXI) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hRy.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0379a);
        } else {
            c0379a = (C0379a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.eXI.size()) {
                c0379a.hvM.getLayoutParams().width = this.hRx;
                c0379a.hvM.getLayoutParams().height = this.hRx;
                c0379a.hvM.reset();
                c0379a.hvM.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.eXI.get(i);
                if (emotionImageData != null) {
                    c0379a.hvM.a(emotionImageData);
                    if (this.hvE != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hvE.add(emotionImageData.getThumbUrl() + c0379a.hvM.getLoadProcType());
                    }
                }
                c0379a.hvM.setVisibility(0);
                c0379a.fzK.setVisibility(8);
            } else if (i == this.eXI.size()) {
                c0379a.fzK.getLayoutParams().width = this.hRx;
                c0379a.fzK.getLayoutParams().height = this.hRx;
                c0379a.hvM.setVisibility(8);
                c0379a.fzK.setVisibility(0);
            }
        }
        return view;
    }

    public void xF(int i) {
        if (this.hRx != i) {
            this.hRx = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hQu = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hRy = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0379a {
        TextView fzK;
        EmotionView hvM;

        C0379a() {
        }
    }

    public void bNW() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hvE != null) {
                    for (String str : a.this.hvE) {
                        if (!TextUtils.isEmpty(str)) {
                            c.asp().qo(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
