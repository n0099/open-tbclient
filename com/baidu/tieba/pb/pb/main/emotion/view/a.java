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
    private List<EmotionImageData> gaF;
    private EmotionView.a iRr;
    private int iSw;
    private PbEmotionBar.a iSx;
    private Set<String> ivY = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gaF)) {
            return 0;
        }
        return this.gaF.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gaF = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0580a c0580a;
        if (view == null) {
            c0580a = new C0580a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0580a.iwg = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0580a.iwg.bzR();
            c0580a.iwg.setController(this.iRr);
            c0580a.iwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iSx != null && (view2 instanceof EmotionView)) {
                        a.this.iSx.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0580a.gzp = (TextView) view.findViewById(R.id.tv_more);
            am.setViewTextColor(c0580a.gzp, (int) R.color.cp_cont_d);
            c0580a.gzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iSx != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.isEmpty(a.this.gaF)) {
                            for (EmotionImageData emotionImageData : a.this.gaF) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.iSx.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0580a);
        } else {
            c0580a = (C0580a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.gaF.size()) {
                c0580a.iwg.getLayoutParams().width = this.iSw;
                c0580a.iwg.getLayoutParams().height = this.iSw;
                c0580a.iwg.reset();
                c0580a.iwg.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.gaF.get(i);
                if (emotionImageData != null) {
                    c0580a.iwg.a(emotionImageData);
                    if (this.ivY != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.ivY.add(emotionImageData.getThumbUrl() + c0580a.iwg.getLoadProcType());
                    }
                }
                c0580a.iwg.setVisibility(0);
                c0580a.gzp.setVisibility(8);
            } else if (i == this.gaF.size()) {
                c0580a.gzp.getLayoutParams().width = this.iSw;
                c0580a.gzp.getLayoutParams().height = this.iSw;
                c0580a.iwg.setVisibility(8);
                c0580a.gzp.setVisibility(0);
            }
        }
        return view;
    }

    public void zj(int i) {
        if (this.iSw != i) {
            this.iSw = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.iRr = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.iSx = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0580a {
        TextView gzp;
        EmotionView iwg;

        C0580a() {
        }
    }

    public void ciC() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.ivY != null) {
                    for (String str : a.this.ivY) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aPQ().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
