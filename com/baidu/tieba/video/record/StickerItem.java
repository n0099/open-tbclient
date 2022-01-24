package com.baidu.tieba.video.record;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class StickerItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_STICKER_ID = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public String desc;
    public int id;
    public String img;
    public boolean isDownLoading;
    public boolean isSelect;
    public String localPath;
    public String name;
    public String resource;
    public int seq;

    public StickerItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
