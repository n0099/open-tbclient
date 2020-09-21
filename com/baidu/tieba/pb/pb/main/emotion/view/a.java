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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> hMh;
    private EmotionView.a kXa;
    private int kYf;
    private PbEmotionBar.a kYg;
    private Set<String> kxY = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.hMh)) {
            return 0;
        }
        return this.hMh.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hMh = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0770a c0770a;
        if (view == null) {
            c0770a = new C0770a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0770a.kyg = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0770a.kyg.ckV();
            c0770a.kyg.setController(this.kXa);
            c0770a.kyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kYg != null && (view2 instanceof EmotionView)) {
                        a.this.kYg.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0770a.iob = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0770a.iob, R.color.cp_cont_d);
            c0770a.iob.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kYg != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.hMh)) {
                            for (EmotionImageData emotionImageData : a.this.hMh) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.kYg.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0770a);
        } else {
            c0770a = (C0770a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.hMh.size()) {
                c0770a.kyg.getLayoutParams().width = this.kYf;
                c0770a.kyg.getLayoutParams().height = this.kYf;
                c0770a.kyg.reset();
                c0770a.kyg.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.hMh.get(i);
                if (emotionImageData != null) {
                    c0770a.kyg.a(emotionImageData);
                    if (this.kxY != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.kxY.add(emotionImageData.getThumbUrl() + c0770a.kyg.getLoadProcType());
                    }
                }
                c0770a.kyg.setVisibility(0);
                c0770a.iob.setVisibility(8);
            } else if (i == this.hMh.size()) {
                c0770a.iob.getLayoutParams().width = this.kYf;
                c0770a.iob.getLayoutParams().height = this.kYf;
                c0770a.kyg.setVisibility(8);
                c0770a.iob.setVisibility(0);
            }
        }
        return view;
    }

    public void Fb(int i) {
        if (this.kYf != i) {
            this.kYf = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.kXa = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.kYg = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    static class C0770a {
        TextView iob;
        EmotionView kyg;

        C0770a() {
        }
    }

    public void cWQ() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.kxY != null) {
                    for (String str : a.this.kxY) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bub().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
