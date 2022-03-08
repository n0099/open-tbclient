package com.baidu.tieba.video.editvideo.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PendantData extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BLACK_TEXT = 2;
    public static final int TYPE_BLUE_TEXT = 1;
    public static final int TYPE_NO = 0;
    public static final int TYPE_PENDANT = 4;
    public static final int TYPE_TRAN_TEXT = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int bottom;
    public String id;
    public String img;
    public int left;
    public String name;
    public int pendantType;
    public String resource;
    public int right;
    public String seq;
    public String size;
    public int top;

    public PendantData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pendantType = 4;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.size)) {
            return;
        }
        String[] split = this.size.split(",");
        if (split.length != 4) {
            return;
        }
        try {
            this.top = Integer.parseInt(split[0]);
            this.left = Integer.parseInt(split[1]);
            this.bottom = Integer.parseInt(split[2]);
            this.right = Integer.parseInt(split[3]);
        } catch (NumberFormatException unused) {
        }
    }

    public PendantData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pendantType = 4;
        this.pendantType = i2;
    }
}
