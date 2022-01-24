package com.baidu.tieba.square.flist;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes13.dex */
public class ForumRankData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6536045499676911895L;
    public transient /* synthetic */ FieldHolder $fh;
    public long ctime;
    public NewErrorData error;
    public int error_code;
    public ForumInfoData[] forumsquare_list;
    public long is_order;
    public long logid;
    public String pic_url;
    public long time;
    public String title;

    public ForumRankData() {
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
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
        this.is_order = 0L;
        this.title = null;
    }
}
