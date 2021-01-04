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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> iRv;
    private EmotionView.a lYl;
    private int lZq;
    private PbEmotionBar.a lZr;
    private Set<String> lyG = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.iRv)) {
            return 0;
        }
        return this.iRv.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iRv = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0820a c0820a;
        if (view == null) {
            c0820a = new C0820a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0820a.lyO = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0820a.lyO.cAN();
            c0820a.lyO.setController(this.lYl);
            c0820a.lyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lZr != null && (view2 instanceof EmotionView)) {
                        a.this.lZr.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0820a.jvZ = (TextView) view.findViewById(R.id.tv_more);
            ao.setViewTextColor(c0820a.jvZ, R.color.CAM_X0109);
            c0820a.jvZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lZr != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!x.isEmpty(a.this.iRv)) {
                            for (EmotionImageData emotionImageData : a.this.iRv) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lZr.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0820a);
        } else {
            c0820a = (C0820a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iRv.size()) {
                c0820a.lyO.getLayoutParams().width = this.lZq;
                c0820a.lyO.getLayoutParams().height = this.lZq;
                c0820a.lyO.reset();
                c0820a.lyO.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iRv.get(i);
                if (emotionImageData != null) {
                    c0820a.lyO.a(emotionImageData);
                    if (this.lyG != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lyG.add(emotionImageData.getThumbUrl() + c0820a.lyO.getLoadProcType());
                    }
                }
                c0820a.lyO.setVisibility(0);
                c0820a.jvZ.setVisibility(8);
            } else if (i == this.iRv.size()) {
                c0820a.jvZ.getLayoutParams().width = this.lZq;
                c0820a.jvZ.getLayoutParams().height = this.lZq;
                c0820a.lyO.setVisibility(8);
                c0820a.jvZ.setVisibility(0);
            }
        }
        return view;
    }

    public void Hu(int i) {
        if (this.lZq != i) {
            this.lZq = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lYl = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lZr = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0820a {
        TextView jvZ;
        EmotionView lyO;

        C0820a() {
        }
    }

    public void dkD() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lyG != null) {
                    for (String str : a.this.lyG) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bGp().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
