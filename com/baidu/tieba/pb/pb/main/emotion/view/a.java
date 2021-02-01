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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> iSv;
    private Set<String> lCe = new HashSet();
    private EmotionView.a mcK;
    private int mdP;
    private PbEmotionBar.a mdQ;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iSv)) {
            return 0;
        }
        return this.iSv.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iSv = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0839a c0839a;
        if (view == null) {
            c0839a = new C0839a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0839a.lCm = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0839a.lCm.cyh();
            c0839a.lCm.setController(this.mcK);
            c0839a.lCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mdQ != null && (view2 instanceof EmotionView)) {
                        a.this.mdQ.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0839a.jwZ = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0839a.jwZ, R.color.CAM_X0109);
            c0839a.jwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mdQ != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.iSv)) {
                            for (EmotionImageData emotionImageData : a.this.iSv) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.mdQ.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0839a);
        } else {
            c0839a = (C0839a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iSv.size()) {
                c0839a.lCm.getLayoutParams().width = this.mdP;
                c0839a.lCm.getLayoutParams().height = this.mdP;
                c0839a.lCm.reset();
                c0839a.lCm.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iSv.get(i);
                if (emotionImageData != null) {
                    c0839a.lCm.a(emotionImageData);
                    if (this.lCe != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lCe.add(emotionImageData.getThumbUrl() + c0839a.lCm.getLoadProcType());
                    }
                }
                c0839a.lCm.setVisibility(0);
                c0839a.jwZ.setVisibility(8);
            } else if (i == this.iSv.size()) {
                c0839a.jwZ.getLayoutParams().width = this.mdP;
                c0839a.jwZ.getLayoutParams().height = this.mdP;
                c0839a.lCm.setVisibility(8);
                c0839a.jwZ.setVisibility(0);
            }
        }
        return view;
    }

    public void Gh(int i) {
        if (this.mdP != i) {
            this.mdP = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.mcK = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.mdQ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0839a {
        TextView jwZ;
        EmotionView lCm;

        C0839a() {
        }
    }

    public void diN() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lCe != null) {
                    for (String str : a.this.lCe) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bCP().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
