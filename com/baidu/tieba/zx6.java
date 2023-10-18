package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import java.util.List;
/* loaded from: classes9.dex */
public interface zx6 {
    void c();

    void d(ay6 ay6Var);

    void e(VlogEditManager vlogEditManager, MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter);

    void f();

    void i(float f);

    @Nullable
    List<MultiMediaData> j();

    void l();

    void m(String str);

    boolean o();

    void onDestroy();

    float p();

    void q(@Nullable List<MultiMediaData> list);

    void reset();
}
