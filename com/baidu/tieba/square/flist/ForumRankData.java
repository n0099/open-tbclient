package com.baidu.tieba.square.flist;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tieba.square.data.ForumInfoData;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ForumRankData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 6536045499676911895L;
    public NewErrorData error;
    public int error_code;
    public ForumInfoData[] forumsquare_list;
    public String pic_url;
    public long time = 0;
    public long ctime = 0;
    public long logid = 0;
    public long is_order = 0;
    public String title = null;
}
