package com.baidu.tieba.view.cloudmusic.data;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public class CloudMusicData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("music_tag_list")
    public List<MusicTagList> music_tag_list;
    @SerializedName(PushConstants.SUB_TAGS_STATUS_LIST)
    public List<TagList> tag_list;

    /* loaded from: classes7.dex */
    public static class MusicTagList extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("music_list")
        public List<MusicList> music_list;
        @SerializedName("page")
        public Page page;
        @SerializedName("tag_id")
        public int tag_id;

        /* loaded from: classes7.dex */
        public static class MusicList extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 3;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName(NotificationCompat.CarExtender.KEY_AUTHOR)
            public String author;
            @SerializedName("duration")
            public int duration;
            @SerializedName("image")
            public String image;
            @SerializedName("isLoading")
            public boolean isLoading;
            @SerializedName(CloudMusicActivityConfig.MUSIC_ID)
            public int music_id;
            @SerializedName("name")
            public String name;
            @SerializedName("resource")
            public String resource;

            public MusicList() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.isLoading = false;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || MusicList.class != obj.getClass()) {
                        return false;
                    }
                    MusicList musicList = (MusicList) obj;
                    if (this.duration != musicList.duration || this.music_id != musicList.music_id) {
                        return false;
                    }
                    String str = this.name;
                    if (str == null ? musicList.name != null : !str.equals(musicList.name)) {
                        return false;
                    }
                    String str2 = this.image;
                    if (str2 == null ? musicList.image != null : !str2.equals(musicList.image)) {
                        return false;
                    }
                    String str3 = this.resource;
                    if (str3 == null ? musicList.resource != null : !str3.equals(musicList.resource)) {
                        return false;
                    }
                    String str4 = this.author;
                    String str5 = musicList.author;
                    if (str4 != null) {
                        return str4.equals(str5);
                    }
                    if (str5 == null) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                int i;
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    String str = this.name;
                    int i4 = 0;
                    if (str != null) {
                        i = str.hashCode();
                    } else {
                        i = 0;
                    }
                    int i5 = i * 31;
                    String str2 = this.image;
                    if (str2 != null) {
                        i2 = str2.hashCode();
                    } else {
                        i2 = 0;
                    }
                    int i6 = (i5 + i2) * 31;
                    String str3 = this.resource;
                    if (str3 != null) {
                        i3 = str3.hashCode();
                    } else {
                        i3 = 0;
                    }
                    int i7 = (i6 + i3) * 31;
                    String str4 = this.author;
                    if (str4 != null) {
                        i4 = str4.hashCode();
                    }
                    return ((((i7 + i4) * 31) + this.duration) * 31) + this.music_id;
                }
                return invokeV.intValue;
            }
        }

        /* loaded from: classes7.dex */
        public static class Page extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("has_more")
            public int has_more;
            @SerializedName("pn")
            public int pn;

            public Page() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public MusicTagList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class TagList extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;

        public TagList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public CloudMusicData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
