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
    private List<EmotionImageData> iup;
    private EmotionView.a lFe;
    private int lGj;
    private PbEmotionBar.a lGk;
    private Set<String> lfW = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iup)) {
            return 0;
        }
        return this.iup.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iup = list;
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
            c0820a.lge = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0820a.lge.ctE();
            c0820a.lge.setController(this.lFe);
            c0820a.lge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lGk != null && (view2 instanceof EmotionView)) {
                        a.this.lGk.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0820a.iVZ = (TextView) view.findViewById(R.id.tv_more);
            ap.setViewTextColor(c0820a.iVZ, R.color.CAM_X0109);
            c0820a.iVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lGk != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!y.isEmpty(a.this.iup)) {
                            for (EmotionImageData emotionImageData : a.this.iup) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lGk.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0820a);
        } else {
            c0820a = (C0820a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iup.size()) {
                c0820a.lge.getLayoutParams().width = this.lGj;
                c0820a.lge.getLayoutParams().height = this.lGj;
                c0820a.lge.reset();
                c0820a.lge.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iup.get(i);
                if (emotionImageData != null) {
                    c0820a.lge.a(emotionImageData);
                    if (this.lfW != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lfW.add(emotionImageData.getThumbUrl() + c0820a.lge.getLoadProcType());
                    }
                }
                c0820a.lge.setVisibility(0);
                c0820a.iVZ.setVisibility(8);
            } else if (i == this.iup.size()) {
                c0820a.iVZ.getLayoutParams().width = this.lGj;
                c0820a.iVZ.getLayoutParams().height = this.lGj;
                c0820a.lge.setVisibility(8);
                c0820a.iVZ.setVisibility(0);
            }
        }
        return view;
    }

    public void GL(int i) {
        if (this.lGj != i) {
            this.lGj = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lFe = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lGk = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    static class C0820a {
        TextView iVZ;
        EmotionView lge;

        C0820a() {
        }
    }

    public void dfG() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lfW != null) {
                    for (String str : a.this.lfW) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bAt().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
