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
    private List<EmotionImageData> iSJ;
    private Set<String> lCs = new HashSet();
    private EmotionView.a mcZ;
    private int mee;
    private PbEmotionBar.a mef;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iSJ)) {
            return 0;
        }
        return this.iSJ.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iSJ = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0840a c0840a;
        if (view == null) {
            c0840a = new C0840a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0840a.lCA = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0840a.lCA.cyo();
            c0840a.lCA.setController(this.mcZ);
            c0840a.lCA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mef != null && (view2 instanceof EmotionView)) {
                        a.this.mef.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0840a.jxn = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0840a.jxn, R.color.CAM_X0109);
            c0840a.jxn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mef != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.iSJ)) {
                            for (EmotionImageData emotionImageData : a.this.iSJ) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.mef.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0840a);
        } else {
            c0840a = (C0840a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iSJ.size()) {
                c0840a.lCA.getLayoutParams().width = this.mee;
                c0840a.lCA.getLayoutParams().height = this.mee;
                c0840a.lCA.reset();
                c0840a.lCA.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iSJ.get(i);
                if (emotionImageData != null) {
                    c0840a.lCA.a(emotionImageData);
                    if (this.lCs != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lCs.add(emotionImageData.getThumbUrl() + c0840a.lCA.getLoadProcType());
                    }
                }
                c0840a.lCA.setVisibility(0);
                c0840a.jxn.setVisibility(8);
            } else if (i == this.iSJ.size()) {
                c0840a.jxn.getLayoutParams().width = this.mee;
                c0840a.jxn.getLayoutParams().height = this.mee;
                c0840a.lCA.setVisibility(8);
                c0840a.jxn.setVisibility(0);
            }
        }
        return view;
    }

    public void Gh(int i) {
        if (this.mee != i) {
            this.mee = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.mcZ = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.mef = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0840a {
        TextView jxn;
        EmotionView lCA;

        C0840a() {
        }
    }

    public void diU() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lCs != null) {
                    for (String str : a.this.lCs) {
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
