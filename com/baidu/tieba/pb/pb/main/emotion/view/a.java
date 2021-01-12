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
    private List<EmotionImageData> iMO;
    private EmotionView.a lTG;
    private int lUL;
    private PbEmotionBar.a lUM;
    private Set<String> lua = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.iMO)) {
            return 0;
        }
        return this.iMO.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iMO = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0836a c0836a;
        if (view == null) {
            c0836a = new C0836a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0836a.lui = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0836a.lui.cwW();
            c0836a.lui.setController(this.lTG);
            c0836a.lui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lUM != null && (view2 instanceof EmotionView)) {
                        a.this.lUM.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0836a.jrt = (TextView) view.findViewById(R.id.tv_more);
            ao.setViewTextColor(c0836a.jrt, R.color.CAM_X0109);
            c0836a.jrt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lUM != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!x.isEmpty(a.this.iMO)) {
                            for (EmotionImageData emotionImageData : a.this.iMO) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.lUM.c(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0836a);
        } else {
            c0836a = (C0836a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.iMO.size()) {
                c0836a.lui.getLayoutParams().width = this.lUL;
                c0836a.lui.getLayoutParams().height = this.lUL;
                c0836a.lui.reset();
                c0836a.lui.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.iMO.get(i);
                if (emotionImageData != null) {
                    c0836a.lui.a(emotionImageData);
                    if (this.lua != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.lua.add(emotionImageData.getThumbUrl() + c0836a.lui.getLoadProcType());
                    }
                }
                c0836a.lui.setVisibility(0);
                c0836a.jrt.setVisibility(8);
            } else if (i == this.iMO.size()) {
                c0836a.jrt.getLayoutParams().width = this.lUL;
                c0836a.jrt.getLayoutParams().height = this.lUL;
                c0836a.lui.setVisibility(8);
                c0836a.jrt.setVisibility(0);
            }
        }
        return view;
    }

    public void FO(int i) {
        if (this.lUL != i) {
            this.lUL = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.lTG = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.lUM = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0836a {
        TextView jrt;
        EmotionView lui;

        C0836a() {
        }
    }

    public void dgM() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.lua != null) {
                    for (String str : a.this.lua) {
                        if (!TextUtils.isEmpty(str)) {
                            c.bCx().deletePic(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
