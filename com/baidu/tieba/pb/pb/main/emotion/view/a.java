package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> itB;
    private EmotionView.a lEN;
    private int lFS;
    private PbEmotionBar.a lFT;
    private Set<String> lfF = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.itB)) {
            return 0;
        }
        return this.itB.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.itB = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0818a c0818a;
        if (view == null) {
            c0818a = new C0818a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0818a.lfN = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0818a.lfN.cub();
            c0818a.lfN.setController(this.lEN);
            c0818a.lfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lFT != null && (view2 instanceof EmotionView)) {
                        a.this.lFT.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0818a.iVn = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0818a.iVn, R.color.cp_cont_d);
            c0818a.iVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lFT != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.itB)) {
                            for (EmotionImageData emotionImageData : a.this.itB) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lFT.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0818a);
        } else {
            c0818a = (C0818a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.itB.size()) {
                c0818a.lfN.getLayoutParams().width = this.lFS;
                c0818a.lfN.getLayoutParams().height = this.lFS;
                c0818a.lfN.reset();
                c0818a.lfN.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.itB.get(i);
                if (emotionImageData != null) {
                    c0818a.lfN.a(emotionImageData);
                    if (this.lfF != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lfF.add(emotionImageData.getThumbUrl() + c0818a.lfN.getLoadProcType());
                    }
                }
                c0818a.lfN.setVisibility(0);
                c0818a.iVn.setVisibility(8);
            } else if (i == this.itB.size()) {
                c0818a.iVn.getLayoutParams().width = this.lFS;
                c0818a.iVn.getLayoutParams().height = this.lFS;
                c0818a.lfN.setVisibility(8);
                c0818a.iVn.setVisibility(0);
            }
        }
        return view;
    }

    public void Gn(int i) {
        if (this.lFS != i) {
            this.lFS = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lEN = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lFT = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0818a {
        TextView iVn;
        EmotionView lfN;

        C0818a() {
        }
    }

    public void dgj() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lfF != null) {
                    for (String str : a.this.lfF) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bBd().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
