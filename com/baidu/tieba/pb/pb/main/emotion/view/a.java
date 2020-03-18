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
    private List<EmotionImageData> gbA;
    private EmotionView.a iTe;
    private int iUj;
    private PbEmotionBar.a iUk;
    private Set<String> ixK = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gbA)) {
            return 0;
        }
        return this.gbA.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gbA = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0581a c0581a;
        if (view == null) {
            c0581a = new C0581a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0581a.ixS = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0581a.ixS.bzY();
            c0581a.ixS.setController(this.iTe);
            c0581a.ixS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iUk != null && (view2 instanceof EmotionView)) {
                        a.this.iUk.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0581a.gAz = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0581a.gAz, (int) R.color.cp_cont_d);
            c0581a.gAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iUk != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gbA)) {
                            for (EmotionImageData emotionImageData : a.this.gbA) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iUk.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0581a);
        } else {
            c0581a = (C0581a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gbA.size()) {
                c0581a.ixS.getLayoutParams().width = this.iUj;
                c0581a.ixS.getLayoutParams().height = this.iUj;
                c0581a.ixS.reset();
                c0581a.ixS.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gbA.get(i);
                if (emotionImageData != null) {
                    c0581a.ixS.a(emotionImageData);
                    if (this.ixK != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.ixK.add(emotionImageData.getThumbUrl() + c0581a.ixS.getLoadProcType());
                    }
                }
                c0581a.ixS.setVisibility(0);
                c0581a.gAz.setVisibility(8);
            } else if (i == this.gbA.size()) {
                c0581a.gAz.getLayoutParams().width = this.iUj;
                c0581a.gAz.getLayoutParams().height = this.iUj;
                c0581a.ixS.setVisibility(8);
                c0581a.gAz.setVisibility(0);
            }
        }
        return view;
    }

    public void zr(int i) {
        if (this.iUj != i) {
            this.iUj = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.iTe = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iUk = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0581a {
        TextView gAz;
        EmotionView ixS;

        C0581a() {
        }
    }

    public void ciX() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.ixK != null) {
                    for (String str : a.this.ixK) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aPV().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
