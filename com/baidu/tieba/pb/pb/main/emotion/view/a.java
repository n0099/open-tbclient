package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes16.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> hrK;
    private Set<String> jZW = new HashSet();
    private EmotionView.a kyM;
    private int kzR;
    private PbEmotionBar.a kzS;

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.hrK)) {
            return 0;
        }
        return this.hrK.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hrK = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0722a c0722a;
        if (view == null) {
            c0722a = new C0722a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0722a.kae = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0722a.kae.bXl();
            c0722a.kae.setController(this.kyM);
            c0722a.kae.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kzS != null && (view2 instanceof EmotionView)) {
                        a.this.kzS.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0722a.hSL = (TextView) view.findViewById(R.id.tv_more);
            ao.setViewTextColor(c0722a.hSL, R.color.cp_cont_d);
            c0722a.hSL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kzS != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!x.isEmpty(a.this.hrK)) {
                            for (EmotionImageData emotionImageData : a.this.hrK) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.kzS.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0722a);
        } else {
            c0722a = (C0722a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.hrK.size()) {
                c0722a.kae.getLayoutParams().width = this.kzR;
                c0722a.kae.getLayoutParams().height = this.kzR;
                c0722a.kae.reset();
                c0722a.kae.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.hrK.get(i);
                if (emotionImageData != null) {
                    c0722a.kae.a(emotionImageData);
                    if (this.jZW != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.jZW.add(emotionImageData.getThumbUrl() + c0722a.kae.getLoadProcType());
                    }
                }
                c0722a.kae.setVisibility(0);
                c0722a.hSL.setVisibility(8);
            } else if (i == this.hrK.size()) {
                c0722a.hSL.getLayoutParams().width = this.kzR;
                c0722a.hSL.getLayoutParams().height = this.kzR;
                c0722a.kae.setVisibility(8);
                c0722a.hSL.setVisibility(0);
            }
        }
        return view;
    }

    public void Cg(int i) {
        if (this.kzR != i) {
            this.kzR = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.kyM = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.kzS = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C0722a {
        TextView hSL;
        EmotionView kae;

        C0722a() {
        }
    }

    public void cIv() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.jZW != null) {
                    for (String str : a.this.jZW) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bkk().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
