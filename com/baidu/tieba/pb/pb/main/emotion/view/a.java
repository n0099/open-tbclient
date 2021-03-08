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
    private List<EmotionImageData> iUs;
    private Set<String> lEu = new HashSet();
    private EmotionView.a mfc;
    private int mgh;
    private PbEmotionBar.a mgi;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iUs)) {
            return 0;
        }
        return this.iUs.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iUs = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0846a c0846a;
        if (view == null) {
            c0846a = new C0846a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0846a.lEC = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0846a.lEC.cyu();
            c0846a.lEC.setController(this.mfc);
            c0846a.lEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mgi != null && (view2 instanceof EmotionView)) {
                        a.this.mgi.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0846a.jyW = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0846a.jyW, R.color.CAM_X0109);
            c0846a.jyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mgi != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.iUs)) {
                            for (EmotionImageData emotionImageData : a.this.iUs) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.mgi.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0846a);
        } else {
            c0846a = (C0846a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iUs.size()) {
                c0846a.lEC.getLayoutParams().width = this.mgh;
                c0846a.lEC.getLayoutParams().height = this.mgh;
                c0846a.lEC.reset();
                c0846a.lEC.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iUs.get(i);
                if (emotionImageData != null) {
                    c0846a.lEC.a(emotionImageData);
                    if (this.lEu != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lEu.add(emotionImageData.getThumbUrl() + c0846a.lEC.getLoadProcType());
                    }
                }
                c0846a.lEC.setVisibility(0);
                c0846a.jyW.setVisibility(8);
            } else if (i == this.iUs.size()) {
                c0846a.jyW.getLayoutParams().width = this.mgh;
                c0846a.jyW.getLayoutParams().height = this.mgh;
                c0846a.lEC.setVisibility(8);
                c0846a.jyW.setVisibility(0);
            }
        }
        return view;
    }

    public void Gk(int i) {
        if (this.mgh != i) {
            this.mgh = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.mfc = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.mgi = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0846a {
        TextView jyW;
        EmotionView lEC;

        C0846a() {
        }
    }

    public void djd() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lEu != null) {
                    for (String str : a.this.lEu) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bCS().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
