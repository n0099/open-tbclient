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
    private EmotionView.a lYk;
    private int lZp;
    private PbEmotionBar.a lZq;
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
        C0853a c0853a;
        if (view == null) {
            c0853a = new C0853a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0853a.lyO = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0853a.lyO.cAO();
            c0853a.lyO.setController(this.lYk);
            c0853a.lyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lZq != null && (view2 instanceof EmotionView)) {
                        a.this.lZq.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0853a.jvZ = (TextView) view.findViewById(R.id.tv_more);
            ao.setViewTextColor(c0853a.jvZ, R.color.CAM_X0109);
            c0853a.jvZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lZq != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!x.isEmpty(a.this.iRv)) {
                            for (EmotionImageData emotionImageData : a.this.iRv) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lZq.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0853a);
        } else {
            c0853a = (C0853a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iRv.size()) {
                c0853a.lyO.getLayoutParams().width = this.lZp;
                c0853a.lyO.getLayoutParams().height = this.lZp;
                c0853a.lyO.reset();
                c0853a.lyO.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iRv.get(i);
                if (emotionImageData != null) {
                    c0853a.lyO.a(emotionImageData);
                    if (this.lyG != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lyG.add(emotionImageData.getThumbUrl() + c0853a.lyO.getLoadProcType());
                    }
                }
                c0853a.lyO.setVisibility(0);
                c0853a.jvZ.setVisibility(8);
            } else if (i == this.iRv.size()) {
                c0853a.jvZ.getLayoutParams().width = this.lZp;
                c0853a.jvZ.getLayoutParams().height = this.lZp;
                c0853a.lyO.setVisibility(8);
                c0853a.jvZ.setVisibility(0);
            }
        }
        return view;
    }

    public void Hu(int i) {
        if (this.lZp != i) {
            this.lZp = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lYk = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lZq = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0853a {
        TextView jvZ;
        EmotionView lyO;

        C0853a() {
        }
    }

    public void dkE() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lyG != null) {
                    for (String str : a.this.lyG) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bGq().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
